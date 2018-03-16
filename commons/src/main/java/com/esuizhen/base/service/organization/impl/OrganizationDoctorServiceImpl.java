package com.esuizhen.base.service.organization.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.esuizhen.base.dao.organization.OrganizationDoctorDao;
import com.esuizhen.base.model.OrganizationDoctorInfo;
import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.westangel.common.util.LogUtil;

@Service
public class OrganizationDoctorServiceImpl implements OrganizationDoctorService {

	// 角色=医生
	final String META_ROLE_DOCTOR = "1";

	// 角色=临床科室主任
	final String META_ROLE_CLINICAL_DIRECTOR = "10";

	// 角色=临床科室科密
	final String META_ROLE_CLINICA_SECRETARY = "11";

	// 角色=科室主任
	final String META_ROLE_DEPARTMENTS_HEADS = "105";
	
	// 角色=病案编目管理员
	final String META_ROLE_CATALOGUE = "55";	
	
	// 角色=客服角色
	final String META_ROLE_SERVICE = "56";
	
	// 管理员角色
	private static final String ADMIN_ROLE = "12";
	// 院长角色
	private static final String DEAN_ROLE = "6";
	// 随访主任角色
	private static final String FOLLOW_DIRECTOR_ROLE = "5";
	// 随访护士角色
	private static final String FOLLOW_NURSE_ROLE = "3";
	// 医生角色
	private static final String DOCTOR_ROLE = "1";
	// 通用角色
	private static final String CURRENCY_ROLE = "13";

	@Autowired
	private OrganizationDoctorDao dao;
	private String deptIds = "";

	@Override
	public OrganizationDoctorInfo getOrganzationDoctorInfo(Long doctorId, Long userId) {
		LogUtil.log.debug("doctorId=" + doctorId + ",userId=" + userId);
		return dao.queryOrganzationDoctorInfo(doctorId, userId);
	}

	@Override
	public String getPatientSql(Long doctorId, Long userId) {
		OrganizationDoctorInfo org = this.getOrganzationDoctorInfo(doctorId, userId);
		if (org == null)
			return null;
		return this.splicedSql(org);
	}

	@Override
	public String getDoctorIdSql(Long doctorId, Long userId) {
		if ((doctorId == null) && (userId == null)) {
			return null;
		}
		OrganizationDoctorInfo doctorInfo = dao.queryDoctorRoleById(doctorId, userId);
		OrganizationDoctorInfo org = this.getOrganzationDoctorInfo(doctorId, userId);
		String userRole = doctorInfo.getUserRole();
		if (org == null || userRole == null)
			return null;
		// 当角色为院长，随访护士，随访主任时
		if (userRole.equals(FOLLOW_NURSE_ROLE) || userRole.equals(FOLLOW_DIRECTOR_ROLE) || userRole.equals(DEAN_ROLE) || userRole.equals(ADMIN_ROLE)) {
			String sql = "SELECT t1.doctorId FROM user_db.r_hospital_doctor t1 where t1.hospitalId = " + org.getHospitalId();
			return sql;
		}
		if (org.getDoctorLevel() == -1 && (userRole.equals(DOCTOR_ROLE) || userRole.equals(CURRENCY_ROLE))) { // 当为医生时
			String sql = " select doctorId from user_db.u_doctor where doctorId =" + doctorId;
			return sql;
		} else {
			return this.splicedDoctorSql(org);
		}
	}

	/**
	 * 不进行区分云端和B端
	 * 
	 * @param org
	 * @return
	 */
	private String splicedDoctorSql(OrganizationDoctorInfo org) {
		StringBuffer sql = new StringBuffer();
		String re = " ";
		if (org.getDoctorLevel() == 1) { // 当为院长时或者随访人员时
											// r_doctor表中没有随访人员角色
			sql.append("SELECT t1.doctorId FROM user_db.r_hospital_doctor t1 where t1.hospitalId = " + org.getHospitalId());
		} else {
			if (org.getDoctorLevel() != -1) {// 医生存在组织架构中
				sql.append("select r.doctorId from user_db.r_doctor r where").append(re);
				switch (org.getDoctorLevel()) {
				case 1:// 院长
					sql.append("r.deanDoctorId");
					break;
				case 2:// 科主任
					sql.append("r.deptDoctorId");
					break;
				case 21:// 科秘
					sql.append("r.deptSecDoctorId");
					break;
				case 3:// 主任
					sql.append("r.directorDoctorId");
					break;
				case 4:// 主治
					sql.append("r.inchargeDoctorId");
					break;
				case 5:// 住院
					sql.append("r.inhospitalDoctorId");
					break;
				default:// 普通医生
					sql.append("r.doctorId");
					break;
				}
				sql.append("=").append(org.getDoctorId()).append(re).append("AND r.state=1").append(re);
			}

			if (org.getDeptId() != null && (org.getDoctorLevel() == 2 || org.getDoctorLevel() == 21)) {// 存在科室且是科主任和科秘
				List<Integer> ids = new ArrayList<Integer>();
				deptIds = org.getDeptId() + ",";
				ids.add(org.getDeptId());
				String deptIds = foreachMethod(ids);
				sql.append("UNION").append(re);
				sql.append("SELECT t1.doctorId FROM user_db.r_hospital_doctor t1 WHERE t1.deptId in(").append(deptIds).append("-1)");
			}
		}
		return sql.toString();
	}

	public String foreachMethod(List<Integer> ids) {
		List<Integer> deptIdList = dao.queryCountDeptIdByParentId(ids);
		if (deptIdList != null && deptIdList.size() > 0) {
			deptIds += JSON.toJSONString(deptIdList);
			deptIds = deptIds.replace("[", "");
			deptIds = deptIds.replace("]", ",");
			return foreachMethod(deptIdList);
		}
		return deptIds;
	}

	// 查询sql拼接
	private String splicedSql(OrganizationDoctorInfo org) {
		StringBuffer sql = new StringBuffer();
		String re = "\r\n";
		if (org.getIsLocal() == 1 && org.getDoctorLevel() == 1) {
			// 本地且级别为院长 查询全部患者
			sql.append("SELECT patientId FROM user_db.u_patient");
		} else {
			// 查询医生患者
			sql.append("SELECT patientId FROM user_db.r_doctor_patient WHERE doctorId=").append(org.getDoctorId()).append(re);
			if (org.getDoctorLevel() == 1) {// 云端院长
				sql.append("UNION").append(re);
				sql.append("SELECT t2.patientId FROM user_db.r_hospital_doctor t1").append(re);
				sql.append("JOIN user_db.r_hospital_patient t2 ON t1.hospitalId=t2.hospitalId").append(re);
				sql.append("JOIN user_db.u_patient t3 ON t2.patientId=t3.patientId").append(re);
				sql.append("JOIN user_db.u_user t4 ON t3.userId=t4.userId AND t4.tobFlag=1").append(re);
				sql.append("WHERE t1.doctorId=").append(org.getDoctorId()).append(re);
			}
			if (org.getDoctorLevel() != -1 && org.getDoctorLevel() != 2 && org.getDoctorLevel() != 21 && org.getDoctorLevel() != 1) {// 医生存在组织架构中
																										// 且非科主任和科秘
				sql.append("UNION").append(re);
				sql.append("SELECT t2.patientId FROM user_db.r_doctor t1").append(re);
				sql.append("JOIN user_db.r_doctor_patient t2 ON t1.doctorId=t2.doctorId ").append(re);
				// if (org.getDeptId()
				// != null &&
				// (org.getDoctorLevel()
				// == 2 ||
				// org.getDoctorLevel()
				// == 21))// 存在科室
				// // 且级别是科主任和科秘
				// sql.append("AND t2.outDeptId=").append(org.getDeptId()).append(re);
				if (org.getIsLocal() == 0) {// 如果是云端，查询
											// tobFlag==1
					sql.append("JOIN user_db.u_patient t3 ON t2.patientId=t3.patientId").append(re);
					sql.append("JOIN user_db.u_user t4 ON t3.userId=t4.userId AND t4.tobFlag=1").append(re);
				}
				sql.append("WHERE").append(re);
				switch (org.getDoctorLevel()) {
				case 1:// 院长
					sql.append("t1.deanDoctorId");
					break;
				case 2:// 科主任
					sql.append("t1.deptDoctorId");
					break;
				case 21:// 科秘
					sql.append("t1.deptSecDoctorId");
					break;
				case 3:// 主任
					sql.append("t1.directorDoctorId");
					break;
				case 4:// 主治
					sql.append("t1.inchargeDoctorId");
					break;
				case 5:// 住院
					sql.append("t1.inhospitalDoctorId");
					break;
				default:// 普通医生
					sql.append("t1.doctorId");
					break;
				}
				sql.append("=").append(org.getDoctorId()).append(re).append("AND t1.state=1").append(re);
			}
			if (org.getDeptId() != null && (org.getDoctorLevel() == 2 || org.getDoctorLevel() == 21)) {// 存在科室
																										// 且是科主任和科秘
				sql.append("UNION").append(re);
				// sql.append("SELECT patientId FROM user_db.r_doctor_patient WHERE outDeptId=").append(org.getDeptId());
				sql.append("SELECT patientId FROM user_db.r_dept_patient t1").append(re);// 患者科室表
				sql.append("JOIN(").append(re);
				sql.append("select t1.deptId FROM user_db.u_department t1").append(re);// 科室第三级
				sql.append("JOIN(").append(re);
				sql.append("select t1.deptId FROM user_db.u_department t1").append(re);// 科室第二级
				sql.append("JOIN(").append(re);
				sql.append("select deptId from user_db.u_department WHERE deptId=").append(org.getDeptId()).append(re);// 科室第一级
				sql.append(")t ON t1.parentId=t.deptId OR t1.deptId = t.deptId").append(re);
				sql.append(")t ON t1.parentId=t.deptId OR t1.deptId = t.deptId").append(re);
				sql.append("GROUP BY deptId").append(re);
				sql.append(") t ON t1.deptId = t.deptId").append(re);
			}
		}
		return sql.toString();
	}

	public static void main(String[] args) {
		OrganizationDoctorInfo org = new OrganizationDoctorInfo();
		OrganizationDoctorServiceImpl o = new OrganizationDoctorServiceImpl();
		org.setDoctorId(9l);
		org.setDeptId(null);
		org.setDoctorLevel(3);
		org.setIsLocal(1);
		System.out.println(o.splicedDoctorSql(org));
	}

	/**
	 * 如果是下面几个角色，走权限控制代码
	 */
	@Override
	public boolean queryDoctorRoleById(Long doctorId, Long userId) {
		// 角色配置的是meta_role表信息

		// 获取角色
		OrganizationDoctorInfo doctorInfo = dao.queryDoctorRoleById(doctorId,
				userId);

		LogUtil.log.info("add by zhuguo : userRole ==>"
				+ doctorInfo.getUserRole());

		boolean result = false;

		OrganizationDoctorInfo info = dao.queryDeployLocation();
		String deployLocation = info.getDeployLocation();

		LogUtil.log.info("查询的部署位置是（1=B端，2=云端） ==>" + deployLocation);

		if (deployLocation.equals("2")
				&& !META_ROLE_CATALOGUE.equals(doctorInfo.getUserRole())
				&& !META_ROLE_SERVICE.equals(doctorInfo.getUserRole())) {

			result = true;
		} else if (doctorInfo.getUserRole().equals(META_ROLE_DOCTOR)
				|| doctorInfo.getUserRole().equals(META_ROLE_CLINICAL_DIRECTOR)
				|| doctorInfo.getUserRole().equals(META_ROLE_CLINICA_SECRETARY)
				|| doctorInfo.getUserRole().equals(META_ROLE_DEPARTMENTS_HEADS)) {

			result = true;
		}
		return result;
	}

	/**
	 * 获取用户角色
	 */
	@Override
	public String getDoctorRoleById(Long doctorId, Long userId) {

		// 获取角色
		OrganizationDoctorInfo doctorInfo = dao.queryDoctorRoleById(doctorId, userId);
		LogUtil.log.info("userRole ==>" + doctorInfo.getUserRole());

		return doctorInfo.getUserRole();
	}

}
