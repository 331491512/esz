package com.esuizhen.cloudservice.questionnaire.service;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireDao;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnairePatientInfo;
import com.esuizhen.cloudservice.questionnaire.util.UtilValidate;

@Component
public class QuestionnaireHelper {
	@Autowired
	private QuestionnaireService questionnaireService;
	
	@Autowired
	private QuestionnaireDao questionnaireDao;
	
	public void exportExcel(String questionnaireId,String followupTaskId,String[] headers,String headerFields[],OutputStream out) {
		List<Map<String,String>> subjectList=questionnaireDao.queryQuestionnaireSubjectByQuestionnaireId(questionnaireId);
		
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet();

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCell cell = null;
		Integer column=0;
		for (column = 0; column < headers.length; column++) {
			cell = row.createCell(column);
			cell.setCellValue(headers[column]);
			cell.setCellStyle(style);
		}
		//追加动态表头
		if(UtilValidate.isNotEmpty(subjectList)){
			for(Map<String,String> subject:subjectList){
				cell = row.createCell(column);
				cell.setCellValue((String)subject.get("content"));
				cell.setCellStyle(style);
				column++;
			}
		}
		List<TQuestionnairePatientInfo> questPatientList=questionnaireService.queryPatientAnswerByQuestionnaireId(questionnaireId,followupTaskId);
		String textValue = "";
		int index = 0;
		String getMethodName = null;
		Class<? extends Object> entityClass = null;
		Method getMethod = null;
		try{
			for(TQuestionnairePatientInfo questPatient:questPatientList){
				index++;
				row = sheet.createRow(index);
				int j = 0;
				for (;j < headerFields.length; j++) {
					getMethodName = "get" + headerFields[j].substring(0, 1).toUpperCase() + headerFields[j].substring(1);
					entityClass = questPatient.getClass();
					getMethod = entityClass.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(questPatient, new Object[] {});
					if (UtilValidate.isEmpty(value)) {
						textValue = "";
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					} else {
						// 其它数据类型都当作字符串简单处理
						try {
							textValue = value.toString();
						} catch (Exception e) {
							textValue = "";
						}
					}
					row.createCell(j).setCellValue(textValue);
				}
				
				//动态数据列追加
				List<HashMap<String, Object>> answerList=questPatient.getQuestionnaireAnswerList();
				if(UtilValidate.isNotEmpty(subjectList)){
					String parentOptionId=null;
					for(Map<String, String> subjectKey:subjectList){
						StringBuffer answerContent=new StringBuffer();
						for(HashMap<String, Object> answer:answerList){
							parentOptionId=(String)answer.get("parentOptionId");
							if(subjectKey.get("questionnaireOptionId").equals(parentOptionId)){
								answerContent.append(answer.get("answerContent")).append(" ");
							}
						}
						row.createCell(j).setCellValue(answerContent.toString());
						j++;
					}
				}
			}
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
