package com.esuizhen.cloudservice.user.followuppatient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.westangel.common.util.GeneralUtil;

public class FileUtil {
	
	/**
	 * 通过路径和文件名创建文件对象
	 * @param path
	 * @param prefixFileName 前缀文件名
	 * @param suffix 后缀
	 * @return
	 */
	public synchronized static File createFile(String path,String prefixFileName,String suffix) {
		String fileName = getFileName(prefixFileName);
		createFile(path);
		File file = new File(path+File.separator+fileName+suffix);
		return file;
	}
	
	/**
	 * 获取带时间戳的文件名
	 * @param fileName
	 * @return
	 */
	private static String getFileName(String fileName) {
		StringBuffer fileBuffer = new StringBuffer();
		fileBuffer.append(fileName).append("_").append(GeneralUtil.generatorTimeUUID());
		return fileBuffer.toString();
	}
	
	/**
	 * 临时文件前缀
	 * @return
	 */
	private static String getPrefix() {
		return Constants.TEMP_FILE_NAME;
	}
	
	/**
	 * 临时文件后缀
	 * @return
	 */
	private static String getSuffix() {
		return FileSuffixEnum.EXCEL.getValue();
	}
	
	/** 
     * 创建临时文件
     *  
     * @return
     * @throws IOException
     */  
	public static File createTempFile() throws IOException {
        return File.createTempFile(getPrefix(), getSuffix());
    }
    
	/**
     * 
     * @param srcFile 源文件
     * @param destFile 目标文件
     */
    public static void copyFile(File srcFile ,File destFile) {
    	// 复制文件
        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);  
            }
        }catch(FileNotFoundException e) {
        	e.printStackTrace();
        }catch(IOException e) {
        	e.printStackTrace();
        }finally {
        	try {  
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	/**
	 * 判断文件是否存在,文件的全路径名
	 * @param fileName
	 * @return
	 */
	public static boolean isExistsFile(String fileName){
	    File f = new File(fileName);
	    return f.exists();
    }
	
	/**
	 * 创建文件目录
	 * @param path
	 */
    public static void createFile(String path){
	    File f = new File(path);
	    if(!f.exists()){
	    	f.mkdirs();
	    }
    }
    
    /** 
     * 删除临时文件
     *  
     * @param fileList
     */  
    public static void cleanTempFile(List<File> fileList) { 
        for (File file : fileList) {
            file.delete();
        }
    }
}
