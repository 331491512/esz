package com.esuizhen.cloudservice.followup.service.export.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.followup.bean.PatientExportTemplate;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.dao.exporttemplate.PatientExportTemplateDao;
import com.esuizhen.cloudservice.followup.service.export.FolloupTaskExportService;
import com.esuizhen.cloudservice.followup.util.FileSuffixEnum;
import com.esuizhen.cloudservice.followup.util.FileUtil;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Service("folloupTaskExportService")
public class FolloupTaskExportServiceImpl implements FolloupTaskExportService {
	@Autowired
	private PatientExportTemplateDao templateDao;
	
	@Override
	public String exportFollowupTaskDetail(Map<String,String> req) {
		if(StringUtils.isEmpty(req.get("exportTemplateId")))
			throw new EmptyParamExcption("error param templateId is null");
		PatientExportTemplate template = templateDao.queryById(req.get("exportTemplateId"));
		if(template==null)
			throw new EmptyObjectExcption("template is null  templateId:"+req.get("exportTemplateId"));
		String[] heads = null;
		String[] columns = null;
		heads = template.getHeads().split(",");
		columns = template.getFields().split(",");
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
		
		// {0} 关联查询字段    {1}{2}缺省可扩展
		template.setSqlContent(MessageFormat.format(template.getSqlContent(), req.get("sql"),"",""));
		return exportFile(template.getSqlContent(),req.get("outFilePath"),heads,columns);
	}
	
	//模拟分布式导出
		private String exportFile(final String sql,String outFilePath,String[] heads,final String[] columns){
			//查询获得总条数
			final List dataList = new ArrayList();
			//定义开关
			final Map<String,Object> switchMap = new HashMap<String,Object>();
			//创建文件
			File file = FileUtil.createFile(outFilePath,Constant.FOLLOW_PATIENT_FILE_NAME,FileSuffixEnum.CSV.getValue());
			ExecutorService exec = Executors.newFixedThreadPool(3);
			PrintWriter writerT=null;
			try {
				//创建输出流
//				final PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
				final PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)),"GBK"));
				//解决输出乱码  为文件添加BOM 信息
				//writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
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
	    					List list = templateDao.queryExprotData(sql+" LIMIT "+(i++*maxNum)+","+maxNum);
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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    				}
					}
				};
				exec.execute(selectRun);
				//先进行首行写入
				int length = heads.length;
				int len=length-1;
				for(int i = 0;i < length;i++) {
					writer.print(heads[i] == null ? "" : heads[i].toString().replace("\"", "\"\""));
					if(i < len) {
						writer.print(",");
					}
				}
				writer.println("");
				writer.flush();
				//创建写入线程
				Runnable writeRun = new Runnable(){
	    			@Override
					public void run()
					{
	    				//全局取值
	    				LinkedHashMap<String, Object> map = null;
	    				long startTime = 0l;
	    				//循环调用
	    				while(true){
	    					if(dataList.size()>0){
		    					List rows = (List) dataList.get(0);
		    					if(rows!=null){
		    						LogUtil.log.debug("------write start----------");
		    						startTime = System.currentTimeMillis();
		    						int size = rows.size();
									for (Object row : rows) { //循环行
										map = (LinkedHashMap<String, Object>) row;
										//循环列
										int length = columns.length;
										int len=length-1;
										for(int i = 0;i < length;i++) {
											Object col = map.get(columns[i]);
											writer.print(col == null ? "" : col.toString().replace("\"", "\"\"").replace(",", ";").replaceAll("\r|\n|\t", "")+"\t");
											if(i<len) {
												writer.print(",");
											}
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
}
