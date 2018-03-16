package com.esuizhen.cloudservice.user.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.dao.followuppatient.FollowupPatientDao;
import com.esuizhen.cloudservice.user.followuppatient.util.FileSuffixEnum;
import com.esuizhen.cloudservice.user.followuppatient.util.FileUtil;
import com.esuizhen.cloudservice.user.service.ExportUtilService;
import com.westangel.common.util.LogUtil;

/** 
 * @ClassName: ExportUntil.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月27日
 */
@Service
public class ExportUtilServiceImpl implements ExportUtilService {
	@Autowired
	private FollowupPatientDao patientFollowupDao;
	//模拟分布式导出
	@Override
	public String exportFile(final String sql,String outFilePath,String[] heads,final String[] columns,String fileName){
			//查询获得总条数
//			final Integer totalNum = patientFollowupDao.countDataNum("SELECT COUNT(0) "+sql.substring(sql.indexOf("FROM"), sql.length()));
//			if(totalNum==null||totalNum==0)
//				throw new EmptyObjectExcption(" totalNum is null");
			final List dataList = new ArrayList();
			//定义开关
			final Map<String,Object> switchMap = new HashMap<String,Object>();
			//创建文件
			File file = FileUtil.createFile(outFilePath,fileName,FileSuffixEnum.CSV.getValue());
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
	    					List list = patientFollowupDao.queryPatientInfoBySql(sql+" LIMIT "+(i++*maxNum)+","+maxNum);
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
										for (String key : columns) {
											Object col = map.get(key);
											writer.print(col == null ? "" : "\""+col.toString().replace("\"", "\"\"")+"\"");
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
			return Constants.EXCEL_EXPORT+"/"+file.getName().substring(0, file.getName().indexOf("."))+"/C";
			//return file;
	
	}

}
