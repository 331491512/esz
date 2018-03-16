package com.esuizhen.cloudservice.statistics.service;

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
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.support.JdbcUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.statistics.constant.Constants;
import com.esuizhen.cloudservice.statistics.util.FileUtil;

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

	@Override
	public void exportToZip(File destFile, String titles,Map<String, List<String>> valuesMap) {
		// 每个文件最大行数
     // 文件收集器  
        List<File> fileList = new ArrayList<File>();
        // 临时文件
        File file = null;  
        FileOutputStream fos = null;
        if(valuesMap != null && valuesMap.size() > 0) {
        	try {
        		// 创建临时文件
                file = FileUtil.createTempFile();
                // 打开流
                fos = FileUtils.openOutputStream(file);
                // 放进收集器里
                fileList.add(file);
                // 写文件头
                writeHeaderToOutputStream(fos);
                JSONObject parseObject = JSON.parseObject(titles);
                List<String> valuesList = valuesMap.get("a");
                if(valuesList != null && valuesList.size() > 0) {
                	// 数据区标题栏
                	String titleArray = parseObject.getJSONArray("followupWay").toJSONString();
                	writeTitleToOutputStream(titleArray, fos);
            		for(Object t: valuesList) {
                        // 写实际一行数据
                        writeOneRowToOutputStream(t,fos,titleArray);
                	}
                }
                valuesList = valuesMap.get("b");
                if(valuesList != null && valuesList.size() > 0) {
                	// 数据区标题栏
                	String titleArray = parseObject.getJSONArray("outPatientFlag").toJSONString();
                	writeTitleToOutputStream(titleArray, fos);
            		for(Object t: valuesList) {
                        // 写实际一行数据
                        writeOneRowToOutputStream(t,fos,titleArray);
                	}
                }
                valuesList = valuesMap.get("c");
                if(valuesList != null && valuesList.size() > 0) {
                	// 数据区标题栏
                	String titleArray = parseObject.getJSONArray("followupWayTotal").toJSONString();
                	writeTitleToOutputStream(titleArray, fos);
            		for(Object t: valuesList) {
                        // 写实际一行数据
                        writeOneRowToOutputStream(t,fos,titleArray);
                	}
                }
                
                if (file != null) {
                    // 写文件尾
                    writeFooterToOutputStream(fos);
                    // 关闭流
                    IOUtils.closeQuietly(fos);
                }
                FileUtil.copyFile(file,destFile);
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
}
