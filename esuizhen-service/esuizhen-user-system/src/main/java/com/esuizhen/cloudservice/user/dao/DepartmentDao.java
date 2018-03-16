package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.DepartmentQueryReq;
import com.westangel.common.bean.DepartmentProfile;
import com.westangel.common.bean.SubDeptProfile;

/**
 * 
 * @author YYCHEN
 *
 */
public interface DepartmentDao {

	/**
	 * 根据医院ID获取科室列表
	 * @param hospitalId
	 * @return
	 */
	public List<DepartmentProfile> selectDepartmentByHospitalId(Integer hospitalId);
	
//	/**
//	 * 
//	* @Title: selectSubDeptListByDeptId 
//	* @Description: 根据科室Id获取子科室列表 
//	* @param @param deptId
//	* @param @return    设定文件 
//	* @return List<SubDeptProfile>    返回类型 
//	* @throws
//	 */
//	public List<SubDeptProfile> selectSubDeptListByDeptId(Integer deptId);
	
	/**
	 * 
	* @Title: addDepartment 
	* @Description: 添加科室 
	* @param @param department    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addDepartment(DepartmentProfile department);
	/**
	 * 
	* @Title: updateDepartment 
	* @Description: 更新科室信息 
	* @param @param department    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateDepartment(DepartmentProfile department);
	
	/**
	 * 
	* @Title: addSubDept 
	* @Description: 添加子科室 
	* @param @param department    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addSubDept(SubDeptProfile department);
	
	/**
	 * 
	* @Title: updateSubDept 
	* @Description: 更新子科室信息 
	* @param @param department    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateSubDept(SubDeptProfile department);

	public List<DepartmentProfile> queryDepartment(DepartmentQueryReq req);

	public List<DepartmentProfile> queryDepartmentMateInfo(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :saveParentDept
	 * @Description:添加父科室
	 * @return int
	 * @date 2016年8月19日 下午6:16:03
	 */
	public int saveParentDept(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :clearDeptSubDept
	 * @Description:清楚子科室
	 * @return int
	 * @date 2016年8月19日 下午6:17:03
	 */
	public int clearDeptSubDept(Object param);
}