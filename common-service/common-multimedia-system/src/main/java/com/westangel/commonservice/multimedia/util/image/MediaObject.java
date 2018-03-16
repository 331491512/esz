package com.westangel.commonservice.multimedia.util.image;

public class MediaObject {

	public final static int FILE_TYPE_IMAGE = 1;
	public final static int FILE_TYPE_VOICE = 2;
	
	/**
	 * 文件名
	 */
	public String fileName;
	/**
	 * 文件存储路径
	 */
	public String filePath;
	/**
	 * 文件类型
	 */
	public int fileType;
	/**
	 * 文件内容
	 */
	public byte[] content;
	
}
