package com.esuizhen.cloudservice.user.service.followuppatient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.support.JdbcUtils;

import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.followuppatient.util.FileUtil;
import com.westangel.common.util.LogUtil;

public abstract class AbstractExportBigData implements ExportBigData {
  
    
  
    /** 
     * 数据输出 
     *  
     * @param data 
     * @param fos 
     * @throws IOException 
     */  
    protected void writeToOutputStream(String data, FileOutputStream fos)  
            throws IOException {  
        IOUtils.write(data, fos, "UTF-8");
    } 
  
    /** 
     * 文件开头的写入 
     *  
     * @param fos 
     * @throws IOException 
     */  
    abstract protected void writeHeaderToOutputStream(FileOutputStream fos)  
            throws IOException;  
  
    /** 
     * 文件结尾的写入 
     *  
     * @param fos 
     */  
    abstract protected void writeFooterToOutputStream(FileOutputStream fos)  
            throws IOException;  
  
    /** 
     * 一行数据的写入 
     *  
     * @param rs 
     * @param fos 
     * @throws SQLException 
     * @throws IOException 
     */  
    abstract protected void writeOneRowToOutputStream(Object obj,FileOutputStream fos,final Collection<String> titles) throws IOException;
    
    /**
     * 一行数据的写入 
     * @param fos
     * @param obj
     * @param titles
     * @throws IOException
     */
    abstract protected void writeOneRowToOutputStream(Object obj,FileOutputStream fos,final String titles) throws IOException;
    
    
    /**
     * 
     * @author lichenghao
     * @title :writeOneRowToOutputStream
     * @Description:行数据写入
     * @return void
     * @date 2016年8月30日 下午12:04:24
     */
    abstract protected void writeOneRowToOutputStream(Object t, FileOutputStream fos, String[] titleFields) throws IOException ;
  
    /** 
     * 写数据标题 
     *  
     * @param titles 
     * @param fos 
     * @throws IOException 
     */  
    abstract protected void writeTitleToOutputStream(Collection<String> titles,  
            FileOutputStream fos) throws IOException;
    
    /**
     * 写数据标题 
     * @param titles
     * @param fos
     * @throws IOException
     */
    abstract protected void writeTitleToOutputStream(String titles,  
            FileOutputStream fos) throws IOException;
  
    /** 
     * 打包 压缩成zip 
     *  
     * @param os 
     *            压缩输出流 
     * @param fileList 
     *            被压缩的文件列表 
     * @throws IOException 
     */  
    protected void doZip(OutputStream os, List<File> fileList)  
            throws IOException {
        if (fileList != null && fileList.size() > 0) {  
            byte[] buf = new byte[1024];  
            ZipOutputStream out = new ZipOutputStream(os); 
            for (File file : fileList) {  
                FileInputStream in = new FileInputStream(file);  
                out.putNextEntry(new ZipEntry(file.getName()));  
                int len;  
                while ((len = in.read(buf)) > 0) {  
                    out.write(buf, 0, len);  
                }  
                out.closeEntry();
                in.close();
            }  
            out.close();  
        }  
    }  
  
    /** 
     * 获取单个文件最大行数 
     *  
     * @param maxRow 
     * @return 
     */  
    protected int getMaxRows(int maxRow) {
        return maxRow < Constants.MAX_ROWS ? maxRow : Constants.MAX_ROWS;
    }  
  
    protected String getColumnKey(String columnName) {
        return columnName;
    }  
  
    protected Object getColumnValue(ResultSet rs, int index)
            throws SQLException {
        return JdbcUtils.getResultSetValue(rs, index);
    }
  
    @SuppressWarnings("unchecked")
	@Override
    public void exportToZip(final int maxRow, List<?> resultList,File destFile,List<String> titles,List<String> titleFields,int writeWay) {
        // 每个文件最大行数
        final int max = getMaxRows(maxRow);
     // 文件收集器  
        List<File> fileList = new ArrayList<File>();
        // 行数记录器
        int i = 0;
        // 临时文件
        File file = null;  
        FileOutputStream fos = null;
        if(resultList != null && resultList.size() > 0) {
        	try {
            	for(Object t: resultList) {
            		// 达到最大行数 或者 新建的 创建新文件
                    if (i == max || i == 0) {
                        // 如果不是新文件 为这个文件写入文件尾
                        if (file != null) {
                            // 写文件尾
                            writeFooterToOutputStream(fos);
                            // 关闭流
                            IOUtils.closeQuietly(fos);
                        }
                        // 创建临时文件
                        file = FileUtil.createTempFile();
                        // 打开流
                        fos = FileUtils.openOutputStream(file);
                        // 放进收集器里
                        fileList.add(file);
                        // 写文件头
                        writeHeaderToOutputStream(fos);
                        // 数据区标题栏
                        writeTitleToOutputStream(titles, fos);
                        i = 0;
                    }
                    i++;
                    // 写实际一行数据
                    if(writeWay == 1) {
                    	writeTitleToOutputStream((Collection<String>)t, fos);
                    }else {
                    	writeOneRowToOutputStream(t, fos,titleFields);
                    }
            	}
                if (file != null) {
                    // 写文件尾
                    writeFooterToOutputStream(fos);
                    // 关闭流
                    IOUtils.closeQuietly(fos);
                }
                if(maxRow < Constants.MAX_ROWS) {
                	//临时文件复制到导出文件中
                	FileUtil.copyFile(file,destFile);
                }else {
                	// 打包
                	OutputStream os = new FileOutputStream(destFile);
                	doZip(os, fileList);
                }
            } catch (IOException e) {
            	e.printStackTrace();
                // io异常  
            } finally {
                IOUtils.closeQuietly(fos);
                // 清空临时文件
                FileUtil.cleanTempFile(fileList);
                fileList.clear();
                fileList = null;
            }
        }
    }

	@Override
	public void exportToZip(File destFile, int maxRow, String titles,
			List<?> resultList) {
		// 每个文件最大行数
        final int max = getMaxRows(maxRow);
     // 文件收集器  
        List<File> fileList = new ArrayList<File>();
        // 行数记录器
        int i = 0;
        // 临时文件
        File file = null;  
        FileOutputStream fos = null;
        if(resultList != null && resultList.size() > 0) {
        	try {
            	for(Object t: resultList) {
            		// 达到最大行数 或者 新建的 创建新文件
                    if (i == max || i == 0) {
                        // 如果不是新文件 为这个文件写入文件尾
                        if (file != null) {
                            // 写文件尾
                            writeFooterToOutputStream(fos);
                            // 关闭流
                            IOUtils.closeQuietly(fos);
                        }
                        // 创建临时文件
                        file = FileUtil.createTempFile();
                        // 打开流
                        fos = FileUtils.openOutputStream(file);
                        // 放进收集器里
                        fileList.add(file);
                        // 写文件头
                        writeHeaderToOutputStream(fos);
                        // 数据区标题栏
                        writeTitleToOutputStream(titles, fos);
                        i = 0;
                    }
                    i++;
                    // 写实际一行数据
                    writeOneRowToOutputStream(t,fos,titles);
            	}
                if (file != null) {
                    // 写文件尾
                    writeFooterToOutputStream(fos);
                    // 关闭流
                    IOUtils.closeQuietly(fos);
                }
                if(maxRow < Constants.MAX_ROWS) {
                	//临时文件复制到导出文件中
                	FileUtil.copyFile(file,destFile);
                }else {
                	// 打包
                	OutputStream os = new FileOutputStream(destFile);
                	doZip(os, fileList);
                }
            } catch (IOException e) {
            	e.printStackTrace();
                // io异常  
            } finally {
                IOUtils.closeQuietly(fos);
                // 清空临时文件
                FileUtil.cleanTempFile(fileList);
                fileList.clear();
                fileList = null;
            }
        }
	}
	
	
	/**
	 * 数据写入
	 */
	 @SuppressWarnings("unchecked")
	@Override
	public void exportToZip(final int maxRow, List<?> resultList,File destFile,final String[] titleFields) {
        // 每个文件最大行数
        final int max = getMaxRows(maxRow);
     // 文件收集器  
        final List<File> fileList = new ArrayList<File>();
        // 行数记录器
        int i = 0;
        //首次记录
        boolean flag = true; 
        // 临时文件
        File file = null;  
        FileOutputStream fos = null;
        if(resultList != null && resultList.size() > 0&&resultList.size()<Constants.MAX_ROWS) {
        	try {
            	for(Object t: resultList) {
            		// 达到最大行数 或者 新建的 创建新文件
                    if (i == max || i == 0) {
                        // 如果不是新文件 为这个文件写入文件尾
                        if (file != null) {
                            // 写文件尾
                            writeFooterToOutputStream(fos);
                            // 关闭流
                            IOUtils.closeQuietly(fos);
                        }
                        // 创建临时文件
                        file = FileUtil.createTempFile();
                        // 打开流
                        fos = FileUtils.openOutputStream(file);
                        // 放进收集器里
                        fileList.add(file);
                        // 写文件头
                        writeHeaderToOutputStream(fos);
                        i = 0;
                        writeOneRowToOutputStream(resultList.get(i), fos,titleFields);
                        if(flag){
                        	flag = false;
                        	i++;
                        	continue;
                        }
                    }
                    i++;
                    // 写实际一行数据
                    writeOneRowToOutputStream(t, fos,titleFields);
            	}
                if (file != null) {
                    // 写文件尾
                    writeFooterToOutputStream(fos);
                    // 关闭流
                    IOUtils.closeQuietly(fos);
                }
                if(maxRow < Constants.MAX_ROWS) {
                	//临时文件复制到导出文件中
                	FileUtil.copyFile(file,destFile);
                }else {
                	// 打包
                	OutputStream os = new FileOutputStream(destFile);
                	doZip(os, fileList);
                }
            } catch (IOException e) {
            	e.printStackTrace();
                // io异常  
            } finally {
                IOUtils.closeQuietly(fos);
                // 清空临时文件
                FileUtil.cleanTempFile(fileList);
                fileList.clear();
            }
        }
        else if(resultList != null && resultList.size() > 0&&resultList.size()>Constants.MAX_ROWS){
        	try{
        	ExecutorService exec = Executors.newFixedThreadPool(5);
        	int length = (resultList.size()/Constants.MAX_ROWS)+(resultList.size()%Constants.MAX_ROWS>0?1:0);
        	final List dataList = resultList;
        	for(int item=0;item<length;item++){
        		final int n = item;
        		Runnable run = new Runnable(){
        			@Override
    				public void run()
    				{
        				File file = null;
        				FileOutputStream fos = null;
        				Object row = null;
        				try {
        					LogUtil.logError.error("----"+n+"----start---");
        					//创建临时文件
        					file = FileUtil.createTempFile();
        					//创建输出流
        					fos = FileUtils.openOutputStream(file);
							//写入头部信息
							writeHeaderToOutputStream(fos);
							//定义起始位置
							int start = 1+(n*Constants.MAX_ROWS);
							//定义结束位置
							int end = (n+1)*Constants.MAX_ROWS;
							//确认结束位置
							if(end>dataList.size())
								end = dataList.size()-1;
							//写入文件首行
							writeOneRowToOutputStream(dataList.get(0), fos,titleFields);
							//写入其他行
							for(;start<end;start++){
								row = dataList.get(start);
								writeOneRowToOutputStream(dataList.get(start), fos,titleFields);
								row =null;
							}
							 // 写文件尾
                            writeFooterToOutputStream(fos);
                            // 关闭流
                            fos.flush();
                            IOUtils.closeQuietly(fos);
							fileList.add(file);
						} catch (IOException e) {
							e.printStackTrace();
							file.delete();
						}finally{
							IOUtils.closeQuietly(fos);
						}
    				}
        		};
        		exec.execute(run);
        	}
        	while(fileList.size()!=length){
        		//等待1s
        		Thread.sleep(1*1000);
        	}
        	OutputStream os = new FileOutputStream(destFile);
        	doZip(os, fileList);
        	}catch(Exception e){
        		e.printStackTrace();
        	}finally{
        		FileUtil.cleanTempFile(fileList);
                fileList.clear();
        	}
        }
    }

	
}
