package com.esuizhen.server.sync.utils;

import java.util.List;

import com.alibaba.dubbo.common.json.JSON;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.JsonUtil;

/**
 * Created by Nidan on 2017年03月20 下午 18:28
 */
public class MapperUtils {
	public static void main(String[] args) {
		//toUpdate("patientNo,patientCode,inpatientNo,userId,uuid,mobile,trueName,preTrueName,auditState,auditRemark,nickName,hasVisibleMedicalRecord,sex,birthDate,userPictureUrl,patientRelation,familyName,familyPhone,liveStatus,deathDate,causeOfDeath,underlyCausesOfDeath,isInHospitalDeath,isTumourDeath,bloodType,bloodTypeRH,bodyHeight,disabilityStatus,geneticDiseaseHistory,drugAllergyHistory,medicalPayType,sourceDiagnosis,sourceDiagnosis2,sourceDiagnosis3,sourceDiseaseCode,sourceDiseaseCode2,sourceDiseaseCode3,sourceDiseaseTypeId,sourceDiseaseTypeId2,sourceDiseaseTypeId3,sourceDiseaseTypeName,sourceDiseaseTypeName2,sourceDiseaseTypeName3,icdDiseaseTypeId,icdDiseaseTypeId2,diagnosisType,diagnosisType2,sourceTumorFlag,sourceTumorFlag2,confirmedDate,confirmedDate2,confirmedDate3,confirmedAge,confirmedAge2,diagnosisId,diagnosisId2,inhospitalId,inhospitalId2,sourcePathologyDiagnosis,sourcePathologyDiagnosis2,sourcePathologyDiseaseCode,sourcePathologyDiseaseCode2,secondaryDiagnosis,secondaryDiseaseCode,secondaryPathologyDiagnosis,secondaryPathologyDiseaseCode,attendingDoctor,attendingDoctorUuid,inchargeDoctor,inchargeDoctorUuid,followupFlag,lostFollowupCause,lostFollowupCauseResultValue,lostFollowupTime,oldFollowupFlag,oldLostFollowupCause,oldLostFollowupCauseResultValue,oldLostFollowupTime,createTime,updateTime,codePerson,codePersonName,handleFlag,outPatientFlag,patientType,mergeFlag,mergeFromUuid,mergeTargetUuid,clinicNo,medicareCardNo,medicalCareAreaId,medicalCarePlace,famZipCode,rawCreateTime,lastAttendingDate,bodyWeight,cancelLostFollowupFlag,cancelLostFollowupTime,infoState,stafferType,specialDiseaseRegisterId,otherHospital,serialNo");
		toTrans();
	}
	public static void toInsert(String cloumns){
		System.out.println("INSERT INTO TABLE_NAME(");
		for(String str:cloumns.split(",")){
			System.out.println(str+",");
		}
		System.out.println(")VALUES(");
		for(String str:cloumns.split(",")){
			System.out.println("#{"+str+"},");
		}
		System.out.println(")");
	}
	
	public static void toUpdate(String cloumns){
		System.out.println("update tableName <set>");
		for(String cloumn:cloumns.split(",")){
			System.out.println("<if test=\""+cloumn+"!=null\">");
			System.out.println(cloumn+"=#{"+cloumn+"},");
			System.out.println("</if>");
		}
		System.out.println("</set>");
	}
	
	public static void toTrans(){
		String str = "{\"respCode\":0,\"respMsg\":\"成功\",\"result\":[{\"resultId\":\"076129fa3a3911e6842d001f29e2f5b8\",\"syncFlag\":1,\"syncTime\":\"2017-03-28 19:58:21\"},{\"resultId\":\"076446005b4211e68a3c001635026170\",\"syncFlag\":1,\"syncTime\":\"2017-03-28 19:58:21\"},{\"resultId\":\"07652cf833e811e68213001f29e2f5b8\",\"syncFlag\":1,\"syncTime\":\"2017-03-28 19:58:21\"}]}";
		TMsgResponse<List<Object>> msg = JsonUtil.toObject(str, TMsgResponse.class);
		for(Object obj : msg.getResult()){
			TBatchDataResultInfo info  = JsonUtil.toObject(JsonUtil.toJson(obj), TBatchDataResultInfo.class);
			System.out.println(JsonUtil.toJson(info));
		}
	}
}
