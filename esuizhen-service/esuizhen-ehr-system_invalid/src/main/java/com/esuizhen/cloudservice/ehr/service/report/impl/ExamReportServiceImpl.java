package com.esuizhen.cloudservice.ehr.service.report.impl;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.ExamReportDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.ExamReportDetailDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReport;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReportDetail;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.esuizhen.cloudservice.ehr.service.report.ExamReportService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
public class ExamReportServiceImpl implements ExamReportService {
	
	@Autowired
	private ExamReportDao examReportDao;
	
	@Autowired
	private ExamReportDetailDao examReportDetailDao; 
	@Autowired
	private MetaDataService metaDataService;

	@Override
	public Page<ExamReport> getExamReportList(TExamReportListReq req)throws EmptyObjectExcption {
		if(req.getPatientId()==null){
			throw new EmptyObjectExcption("patientId is empty");
		}
		if(req.getPage()==null){
			req.setPage(0);
		}
		if(req.getNum()==null){
			req.setNum(10);
		}
		List<ExamReport> list = examReportDao.queryExamReportList(req);
		List<ExamReport> subList = new ArrayList<ExamReport>();
		int totalNum =  0;
		if(list!=null&&list.size()!=0&&list.get(0)!=null)totalNum = list.size();
		int num = req.getNum();
		int page = req.getPage();
		int currPage = page+1;
		int totalPage = (int) Math.ceil((double)totalNum/(double)num);//进位取整
		int currSize = currPage<totalPage?num:(totalNum%num==0?num:totalNum%num);
		if(totalNum!=0){
			subList=list.subList(page*num, page*num+currSize);
		}
		Page<ExamReport> page_ExamReport = new Page<ExamReport>();
		page_ExamReport.setCurrPage(page);
		page_ExamReport.setTotalNum(list.size());
		page_ExamReport.setTotalPage(totalPage);
		page_ExamReport.setDataList(subList);
		page_ExamReport.setCurrSize(currSize);
		return page_ExamReport;
	}
	
	@Override
	@Transactional
	public List<ExamReport> batchAddExamReport(List<ExamReport> examReportList) {
		if(UtilValidate.isEmpty(examReportList)){
			throw new EmptyObjectExcption("examReportList is empty");
		}
		for(ExamReport examReport:examReportList){
			this.saveExamReport(examReport);
		}
		return examReportList;
	}
	
	public void saveExamReport(ExamReport examReport){
		if(UtilValidate.isNotEmpty(examReport.getIsDelete()) && examReport.getIsDelete()==1){
			this.examReportDetailDao.deleteByExamReportId(examReport.getExamReportId());
			this.examReportDao.deleteByPrimaryKey(examReport.getExamReportId());
			return;
		}else if(UtilValidate.isNotEmpty(examReport.getExamReportId())){
			//更新检检查方式数据信息
			String mainKey=examReport.getExamChildTypeId()!=null?examReport.getExamChildTypeId().toString():null;
			UserDefinedMetaData metaData = new UserDefinedMetaData();
			metaData.setMainKey(mainKey);
			metaData.setMetaName(examReport.getExamTypeName());
			metaData.setCreator(examReport.getOperatorId());
			metaData.setParentKey(examReport.getExamTypeId().toString());
			
			metaData.setMetaDataTable("meta_e_exam_type");
			metaData.setMainKeyField("examTypeId");
			metaData.setMetaNameField("examTypeName");
			metaData.setParentKeyField("parentId");
			Integer finalKey=this.metaDataService.addMetaDate(metaData);
			examReport.setExamChildTypeId(finalKey);
			//更新业务表信息
			if(UtilValidate.isEmpty(examReport.getEmrId())){
				examReport.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
			}
			this.examReportDao.updateByPrimaryKeySelective(examReport);
			saveSubExamReport(examReport.getExamReportSubItemDetailInfos(),examReport.getExamReportId());
		}else{
			//更新检检查方式数据信息
			String mainKey=examReport.getExamChildTypeId()!=null?examReport.getExamChildTypeId().toString():null;
			UserDefinedMetaData metaData = new UserDefinedMetaData();
			metaData.setMainKey(mainKey);
			metaData.setMetaName(examReport.getExamTypeName());
			metaData.setCreator(examReport.getOperatorId());
			metaData.setParentKey(examReport.getExamTypeId().toString());
			
			metaData.setMetaDataTable("meta_e_exam_type");
			metaData.setMainKeyField("examTypeId");
			metaData.setMetaNameField("examTypeName");
			metaData.setParentKeyField("parentId");
			Integer finalKey=this.metaDataService.addMetaDate(metaData);
			examReport.setExamChildTypeId(finalKey);
			//更新业务表信息
			if(UtilValidate.isEmpty(examReport.getEmrId())){
				examReport.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
			}
			examReport.setExamReportId(GeneralUtil.generatorUUID("EPACS"));
			examReportDao.insert(examReport);
			if(UtilValidate.isNotEmpty(examReport.getExamReportSubItemDetailInfos())){
				saveSubExamReport(examReport.getExamReportSubItemDetailInfos(),examReport.getExamReportId());
			}
		}
		
	}

	public void saveSubExamReport(List<ExamReportDetail> subExamReportList,String examReportId){
		this.examReportDetailDao.deleteByExamReportId(examReportId);
		if(subExamReportList==null||subExamReportList.size()==0||subExamReportList.get(0)==null)return;
		for(ExamReportDetail subExamReport:subExamReportList){
			subExamReport.setExamReportDetailId(GeneralUtil.generatorUUID("ERD"));
			subExamReport.setExamReportId(examReportId);
			examReportDetailDao.insert(subExamReport);
		}
		
	}
}
