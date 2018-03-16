package com.esuizhen.cloudservice.followup.service.review.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.followup.bean.ReBasiserReviewOrderReq;
import com.esuizhen.cloudservice.followup.bean.ReviewRecordReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.common.FileSuffixEnum;
import com.esuizhen.cloudservice.followup.common.FileUtil;
import com.esuizhen.cloudservice.followup.dao.review.FollowupReviewAppointDao;
import com.esuizhen.cloudservice.followup.dao.review.TPatientExportTemplateInfoDao;
import com.esuizhen.cloudservice.followup.dao.user.PatientDao;
import com.esuizhen.cloudservice.followup.model.review.FollowupReviewAppoint;
import com.esuizhen.cloudservice.followup.model.review.TPatientExportTemplateInfo;
import com.esuizhen.cloudservice.followup.service.review.ReviewService;
import com.esuizhen.cloudservice.followup.util.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private FollowupReviewAppointDao reviewAppointDao;
	
	@Autowired
	private TPatientExportTemplateInfoDao templateDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Override
	public int reBasiserReviewOrder(
			ReBasiserReviewOrderReq reBasiserReviewOrderReq) {
		Integer hospitalId = patientDao.queryHospitalByPatientId(reBasiserReviewOrderReq.getPatientId());
		reBasiserReviewOrderReq.setHospitalId(hospitalId);
		reBasiserReviewOrderReq.setAppointId(GeneralUtil.generateUniqueID("APP"));
		reBasiserReviewOrderReq.setSourceFlag("3");
		return reviewAppointDao.insert(reBasiserReviewOrderReq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<FollowupReviewAppoint> queryReviewRecord(
			ReviewRecordReq reviewRecordReq) {
		PageHelper.startPage(reviewRecordReq.getPage() + 1, reviewRecordReq.getNum());
		//搜索复查预约申请表
		Map<String,Object> paramsMap = BeanUtils.toMap(reviewRecordReq);
		List<FollowupReviewAppoint> list = reviewAppointDao.queryByPage(paramsMap);
		// 统计反馈人数
		Page<FollowupReviewAppoint> myPage = PageUtil.returnPage((com.github.pagehelper.Page<FollowupReviewAppoint>) list);
		return myPage;
	}

	@Override
	public String exportReviewRecord(
			ReviewRecordReq reviewRecordReq) {
		TPatientExportTemplateInfo template = templateDao.getPatientExportTemplateById(reviewRecordReq.getExportTemplateId());
		if(template==null)
			throw new EmptyObjectExcption("template is null  templateId:"+reviewRecordReq.getExportTemplateId());
		String[] heads = null;
		String[] columns = null;
		heads = template.getHeads().split(",");
		columns = template.getFields().split(",");
		String sql = template.getSqlContent();
		//对模版顺序进行判断
		if(StringUtils.isNotEmpty(template.getExportSort())){
			//对表头和列进行排序
			String[] sorts = template.getExportSort().split(",");
			String[] fheads = new String[sorts.length];
			String[] fcolumns = new String[sorts.length];
			for(int i=0;i<sorts.length;i++){
				Integer index = Integer.parseInt(sorts[i]);
				fheads[i] = heads[index];
				fcolumns[i] = columns[index];
			}
			heads = fheads;
			columns = fcolumns;
		}
		String whereSql = getConditionValue(reviewRecordReq);
		sql+=whereSql;
		LogUtil.log.debug("导出sql="+sql);
		return exportFile(sql,reviewRecordReq.getOutFilePath(),heads,columns);
	}

	@Override
	public Map<String, Integer> queryReviewOrderSummary(Integer userRole,
			Long userId) {
		return reviewAppointDao.queryReviewOrderSummary(userRole, userId);
	}
	
	//模拟分布式导出
	private String exportFile(final String sql,String outFilePath,String[] heads,final String[] columns){
		final List<List<Map<String,Object>>> dataList = new ArrayList<List<Map<String,Object>>>();
		//定义开关
		final Map<String,Object> switchMap = new HashMap<String,Object>();
		//创建文件
		File file = FileUtil.createFile(outFilePath,Constant.FOLLOW_PATIENT_FILE_NAME,FileSuffixEnum.CSV.getValue());
		ExecutorService exec = Executors.newFixedThreadPool(3);
		PrintWriter writerT=null;
		try {
			//创建输出流
			final PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
			//解决输出乱码  为文件添加BOM 信息
			writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
			writerT = writer;
			//创建查询线程
			Runnable selectRun = new Runnable(){
    			@Override
				public void run()
				{
    				Integer i = 0;
    				int maxNum = 30000;
    				long startTime;
    				while(true){
    					LogUtil.log.debug("--------------select"+i+" start--------------");
    					startTime = System.currentTimeMillis();//时间记录
    					List<Map<String,Object>> list = reviewAppointDao.getRecord(sql+" LIMIT "+(i++*maxNum)+","+maxNum);
    					LogUtil.log.debug("--------------select end time:"+(System.currentTimeMillis()-startTime)+" ms--------------");
    					//查不到数据结束
    					if(list==null||list.size()==0){
    						switchMap.put("select",true);
    						break;
    					}
    					dataList.add(list);
    					try {
							Thread.sleep(500l);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    				}
				}
			};
			exec.execute(selectRun);
			//先进行首行写入
			for(String str:heads){
				writer.print(str == null ? "" : "\""+str.toString().replace("\"", "\"\"")+"\""+",");
			}
			writer.println("");
			writer.flush();
			//创建写入线程
			Runnable writeRun = new Runnable(){
    			@Override
				public void run()
				{
    				long startTime = 0l;
    				//循环调用
    				while(true){
    					if(dataList.size()>0){
	    					List<Map<String,Object>> rows = dataList.get(0);
	    					if(rows!=null){
	    						LogUtil.log.debug("------write start----------");
	    						startTime = System.currentTimeMillis();
	    						int size = rows.size();
								for (Map<String, Object> row : rows) { //循环行
									//循环列
									for (String key : columns) {
										Object col = row.get(key);
										if(col instanceof Date) {
											col = DateUtil.convertToStr((Date)col, DateUtil.DATE_TIME_LINE);
										}
										System.out.println("col###########"+col);
										writer.print(col == null ? "" : "\""+col.toString().replace("\"", "\"\"")+"\"\t");
										writer.print(",");
									}
									writer.print("\r\n");
									writer.flush();
								}
		    					rows.clear();
		    					dataList.remove(0);
		    					LogUtil.log.debug("---------write over----size:"+size+"------times:"+(System.currentTimeMillis()-startTime)+"----------");
	    					}
    					}else if(switchMap.get("select")!=null){
    						switchMap.put("write", true);
    						writer.close();
    						break;
    					}
    					try {
							Thread.sleep(500l);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    				}
				}
			};
			exec.execute(writeRun);
			//循环等待查询/写入完成
			while(switchMap.get("write")==null){
				//等待1s
        		Thread.sleep(1*1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			file.delete();
			exec.shutdown();
			return null;
		}finally {
			writerT.close();
		}
		return Constant.EXCEL_EXPORT+"/"+file.getName().substring(0, file.getName().indexOf("."))+"/C";
	}
	
	String getConditionValue(ReviewRecordReq reviewRecordReq) {
		StringBuffer whereBuffer = new StringBuffer();
		whereBuffer.append(" WHERE 1=1 ");
		String patientName = reviewRecordReq.getPatientName();
		String mobile = reviewRecordReq.getMobile();
		String appointDoctorName = reviewRecordReq.getAppointDoctorName();
		Date beginDate = reviewRecordReq.getBeginDate();
		String beginDateStr = null;
		if(beginDate != null) {
			beginDateStr = DateUtil.convertToStr(beginDate, DateUtil.YMR_SLASH);
		}
		
		Date endDate = reviewRecordReq.getEndDate();
		String endDateStr = null;
		if(endDate != null) {
			endDateStr = DateUtil.convertToStr(endDate, DateUtil.YMR_SLASH);
		}
		Integer appointResult = reviewRecordReq.getAppointResult();
		if(patientName != null) {
			whereBuffer.append(" AND trueName LIKE").append("'%").append(patientName).append("%'");
		}
		if(mobile != null) {
			whereBuffer.append(" AND mobile LIKE").append("'%").append(mobile).append("%'");
		}
		if(appointDoctorName != null) {
			whereBuffer.append(" AND appointDoctorName LIKE").append("'%").append(appointDoctorName).append("%'");
		}
		if(beginDate != null) {
			whereBuffer.append("AND DATE_FORMAT(appointDate,'%Y-%m-%d')>=").append("'").append(beginDateStr).append("'");
		}
		if(endDate != null) {
			whereBuffer.append(" AND DATE_FORMAT(appointDate,'%Y-%m-%d')<=").append("'").append(endDateStr).append("'");
		}
		if(appointResult != null) {
			whereBuffer.append(" AND appointResult=").append(appointResult);
		}
		return whereBuffer.toString();
	}

	@Override
	public int saveReviewOrderAnswer(FollowupReviewAppoint record) {
		// TODO Auto-generated method stub
		return reviewAppointDao.updateByPrimaryKeySelective(record);
		
	}
}
