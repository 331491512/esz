package com.esuizhen.cloudservice.ehr.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterUtils {
	/**
	 * 文件名全称
	 */
	private String filePath;
	/**
	 * 内容追加标示,默认为true。true-追加，false-覆盖
	 */
	private boolean append = true;
	/**
	 * 写文件对象
	 */
	private FileWriter writer = null;
	
	BufferedReader reader = null;
	
	public FileReaderWriterUtils(String filePath,boolean append) {
		this.filePath = filePath;
		FileUtil.createFile(filePath.substring(0, filePath.lastIndexOf(File.separator)));
		this.append = append;
		try {
			writer = new FileWriter(filePath,append);
			reader = new BufferedReader(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createWriter() {
		try {
			writer = new FileWriter(filePath,append);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createReader() {
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		FileUtil.createFile(filePath.substring(0, filePath.lastIndexOf(File.separator)));
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}
	
	/**
	 * 写数据
	 * @param msg 写入内容
	 */
	public void writeLine(String msg) {
		try {
			writer.write(msg+System.lineSeparator());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readLine(Integer counter) {
		StringBuffer sb = new StringBuffer();
		String line = null;
		int i = 0;
		try {
			while((line = reader.readLine()) != null) {
				i++;
				if(i == 1) {
					sb.append(line.replaceFirst("\\d+",counter+""));
				}else {
					sb.append(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public void close() {
		try {
			if(writer != null) {
				writer.close();
			}
			if(reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
