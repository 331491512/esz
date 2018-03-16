/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>DoctorSendFollowupNotifyReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月26日下午3:22:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;
import java.util.List;

import com.westangel.common.bean.PatientGroup;

/** 
* @ClassName: DoctorSendFollowupNotifyReq
* @Description: 
* @author lichenghao
* @date 2016年5月26日 下午3:22:02  
*/
public class DoctorSendFollowupNotifyReq {
		//发送医生userId
		private Long doctorUserId;
		
		//接收患者的userId
		private List<Long> patientUserIds;
		
		//接收分组
		private List<PatientGroup>groups;
		
		//通知内容
		private String content;

		public Long getDoctorUserId() {
			return doctorUserId;
		}

		public void setDoctorUserId(Long doctorUserId) {
			this.doctorUserId = doctorUserId;
		}

		public List<Long> getPatientUserIds() {
			return patientUserIds;
		}

		public void setPatientUserIds(List<Long> patientUserIds) {
			this.patientUserIds = patientUserIds;
		}

		public List<PatientGroup> getGroups() {
			return groups;
		}

		public void setGroups(List<PatientGroup> groups) {
			this.groups = groups;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
}
