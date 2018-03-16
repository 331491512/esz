package com.esuizhen.cloudservice.sync.timerTask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.common.Const;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUserDao;
import com.esuizhen.cloudservice.sync.handle.PushDoctorNotifyHandle;
import com.esuizhen.cloudservice.sync.handle.PushPatientNotifyHandle;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;
import com.westangel.common.bean.user.TTobeconfirmedPatient;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/**
 * 
 * @author YYCHEN
 *
 */
@Service(value = "timerTask")
public class ScanningTimerTask {
	//是否运行
	public static boolean run_flag = true;
	@Autowired
	private MatchUserDao matchUserDao;
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	
	@Autowired
	private PushDoctorNotifyHandle doctorNotifyHandle;
	@Autowired
	private PushPatientNotifyHandle patientNotifyHandle;
	
	/**
	 * 
	 * @Title: accessMatchRecords @Description: 处理匹配记录 @param 设定文件 @return void
	 * 返回类型 @throws
	 */
	public void scanning() {
		//扫描医生
		accessMatchDoctors();
		//扫描患者
		accessMatchPatients();
		run_flag = true;
	}

	/**
	 * 
	 * @Title: accessMatchDoctors @Description: 处理匹配的医生 @param 设定文件 @return void
	 * 返回类型 @throws
	 */
	@SuppressWarnings("unchecked")
	private void accessMatchDoctors() {
		//更新可推送的医生
		int num = this.matchDoctorDao.setNotifyDoctorAgain();
		LogUtil.log.debug("update push doctor size="+num);
		List<String> uuids = new ArrayList<String>();
		Page<TTobeconfirmedDoctor> pageDatas = null;
		//循环扫描 每次100条
		for (int pageIndex = 0, pages = 1, pageSize = 100; run_flag && pageIndex < pages; pages = pageDatas.getTotalPage()) {
			PageHelper.startPage(pageIndex + 1, pageSize);
			List<TTobeconfirmedDoctor> doctors = this.matchDoctorDao.selectNopushDoctors();
			pageDatas = PageUtil.returnPage((com.github.pagehelper.Page<TTobeconfirmedDoctor>)doctors);
			for (TTobeconfirmedDoctor doctor:doctors){
				doctorNotifyHandle.pushNotifyToDoctor(doctor);
				uuids.add(doctor.getUuid());
			}
			if (uuids.size() >0) {
				this.matchDoctorDao.updatePushFlag(uuids, Const.PUSHFLAG_YES);
				uuids.clear();
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					
				}
			}
		}
	}

	

	
	
	/**
	 * 
	 * @Title: accessMatchPatients @Description: 处理匹配的患者 @param 设定文件 @return
	 * void 返回类型 @throws
	 */
	@SuppressWarnings("unchecked")
	private void accessMatchPatients() {
		//更新可推送的患者
		int num = this.matchPatientDao.setNotifyPatientAgain();
		LogUtil.log.debug("update push patient size="+num);
		List<String> uuids = new ArrayList<String>();
		//循环扫描 每次100条
		for (int pageIndex = 0, pages = 1, pageSize = 100; run_flag && pageIndex < pages; pageIndex++) {
			PageHelper.startPage(pageIndex + 1, pageSize);
			List<TTobeconfirmedPatient> patients = this.matchPatientDao.selectNopushPatients();
			Page<TTobeconfirmedPatient> pageDatas = PageUtil.returnPage((com.github.pagehelper.Page<TTobeconfirmedPatient>)patients);
			for(TTobeconfirmedPatient patient:patients){
				patientNotifyHandle.pushNotifyToPatient(patient);
				uuids.add(patient.getUuid());
			}
			if(uuids.size()>0){
				this.matchPatientDao.updatePushFlag(uuids, Const.PUSHFLAG_YES);
				uuids.clear();
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
				}
			}
			pages = pageDatas.getTotalPage();
		}
	}
}
