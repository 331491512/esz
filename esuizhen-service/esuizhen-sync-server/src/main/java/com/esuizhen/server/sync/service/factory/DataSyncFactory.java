/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.factory;<br/>
 * <b>文件名：</b>DataSyncFactory.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月18日下午4:54:35<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.impl.EDiagnosisInfoServiceImpl;
import com.esuizhen.server.sync.service.impl.EcClinicMedicalNoteServiceImpl;
import com.esuizhen.server.sync.service.impl.EciDetectionDetailServiceImpl;
import com.esuizhen.server.sync.service.impl.EciDetectionReportServiceImpl;
import com.esuizhen.server.sync.service.impl.EciExamReportServiceImpl;
import com.esuizhen.server.sync.service.impl.EciSurgeryNoteServiceImpl;
import com.esuizhen.server.sync.service.impl.EciTreatmentNoteServiceImpl;
import com.esuizhen.server.sync.service.impl.FollowupResultBuffServiceImpl;
import com.esuizhen.server.sync.service.impl.FollowupResultServiceImpl;
import com.esuizhen.server.sync.service.impl.InhospitalNoteServiceImpl;
import com.esuizhen.server.sync.service.impl.OutHospitalNoteServiceImpl;
import com.esuizhen.server.sync.service.impl.PatientFamilyServiceImpl;
import com.esuizhen.server.sync.service.impl.PatientServiceImpl;
import com.esuizhen.server.sync.service.impl.RDeptPatientServiceImpl;
import com.esuizhen.server.sync.service.impl.RDoctorPatientServiceImpl;
import com.esuizhen.server.sync.service.impl.RHospitalDoctorServiceImpl;
import com.esuizhen.server.sync.service.impl.RHospitalPatientServiceImpl;
import com.esuizhen.server.sync.service.impl.RUuidPatientNoServiceImpl;
import com.esuizhen.server.sync.service.impl.UserServiceImpl;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: DataSyncFactory
 * @Description:数据处理工厂
 * @author lichenghao
 * @date 2017年3月18日 下午4:54:35
 */
@Component
public class DataSyncFactory {
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private DataSyncService doctorServiceImpl;
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	@Autowired
	private PatientFamilyServiceImpl patientFamilyServiceImpl;
	
	@Autowired
	private RUuidPatientNoServiceImpl rUuidPatientNoServiceImpl;
	
	@Autowired
	private RHospitalDoctorServiceImpl rHospitalDoctorServiceImpl;
	
	@Autowired
	private RHospitalPatientServiceImpl rHospitalPatientServiceImpl;
	
	@Autowired
	private RDoctorPatientServiceImpl rDoctorPatientServiceImpl;
	
	@Autowired
	private RDeptPatientServiceImpl rDeptPatientServiceImpl;
	
	@Autowired
	private InhospitalNoteServiceImpl inhospitalNoteServiceImpl;
	
	@Autowired
	private OutHospitalNoteServiceImpl outHospitalNoteServiceImpl;
	
	@Autowired
	private EDiagnosisInfoServiceImpl eDiagnosisInfoServiceImpl;
	
	@Autowired
	private EcClinicMedicalNoteServiceImpl ecClinicMedicalNoteServiceImpl;
	
	@Autowired
	private EciSurgeryNoteServiceImpl eciSurgeryNoteServiceImpl;
	
	@Autowired
	private EciTreatmentNoteServiceImpl eciTreatmentNoteServiceImpl;
	
	@Autowired
	private EciDetectionReportServiceImpl eciDetectionReportServiceImpl;
	
	@Autowired
	private EciDetectionDetailServiceImpl eciDetectionDetailServiceImpl;
	
	@Autowired
	private EciExamReportServiceImpl eciExamReportServiceImpl;
	
	@Autowired
	private FollowupResultServiceImpl followupResultServiceImpl;
	
	@Autowired
	private FollowupResultBuffServiceImpl followupResultBuffServiceImpl;
	//获取调用实体
	public DataSyncService getDataSyncServiceInvoker(Integer tableId) {
		switch (tableId) {
		case ConstantSync.TableId.USER:
			return userServiceImpl;
		case ConstantSync.TableId.DOCTOR:
			
			return doctorServiceImpl;
		case ConstantSync.TableId.PATIENT:
			
			return patientServiceImpl;
		case ConstantSync.TableId.CONTACT:
			
			return patientFamilyServiceImpl;
		case ConstantSync.TableId.UUID_PATIENTNO:
			
			return rUuidPatientNoServiceImpl;
		case ConstantSync.TableId.R_DOCTOR_PATIENT:
			
			return rDoctorPatientServiceImpl;
			
		case ConstantSync.TableId.R_HOSPITAL_DOCTOR:
			
			return rHospitalDoctorServiceImpl;
		case ConstantSync.TableId.R_HOSPITAL_PATIENT:
			
			return rHospitalPatientServiceImpl;
		case ConstantSync.TableId.R_DEPT_PATIENT:
			
			return rDeptPatientServiceImpl;
			
		case ConstantSync.TableId.INHOSPITAL:
			
			return inhospitalNoteServiceImpl;
		case ConstantSync.TableId.OUTHOSPITAL:
			
			return outHospitalNoteServiceImpl;
		case ConstantSync.TableId.CLINIC_MEDICAL:
			
			return ecClinicMedicalNoteServiceImpl;
		case ConstantSync.TableId.DIAGNOSIS:
			
			return eDiagnosisInfoServiceImpl;
		case ConstantSync.TableId.SURGERY:
			
			return eciSurgeryNoteServiceImpl;
		case ConstantSync.TableId.TREATMENT:
			
			return eciTreatmentNoteServiceImpl;
		case ConstantSync.TableId.DETETION_REPORT:
			
			return eciDetectionReportServiceImpl;
		case ConstantSync.TableId.DETETION_DETAIL:
			
			return eciDetectionDetailServiceImpl;
		case ConstantSync.TableId.EXAM_REPROT:
			
			return eciExamReportServiceImpl;
		case ConstantSync.TableId.FOLLOWUP_RESULT:
			
			return followupResultServiceImpl;
			
		case ConstantSync.TableId.FOLLOWUP_RESULT_BUFF:
			
			return followupResultBuffServiceImpl;
		}
		LogUtil.logError.error("ERROR when getDataSyncServiceInvoker(): invlaid tableId: " + tableId);
		return null;
	}
}
