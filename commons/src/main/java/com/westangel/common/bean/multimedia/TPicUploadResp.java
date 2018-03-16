package com.westangel.common.bean.multimedia;

public class TPicUploadResp
{
	/**
	 * 图片路径
	 */
	private String picUrl;

	/**
	 * 音频路径
	 */
	private String audioUrl;
	
	/**
	 * 文件
	 */
	private String fileUrl;
	
	/**
	 * 文件路径
	 */
	private String filePath;
	
	/**
	 * 可视化文件
	 */
	private String previewFileUrl;
	
	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public String getAudioUrl()
	{
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl)
	{
		this.audioUrl = audioUrl;
	}

	public String getFileUrl()
	{
		return fileUrl;
	}

	public void setFileUrl(String fileUrl)
	{
		this.fileUrl = fileUrl;
	}

	public String getPreviewFileUrl()
	{
		return previewFileUrl;
	}

	public void setPreviewFileUrl(String previewFileUrl)
	{
		this.previewFileUrl = previewFileUrl;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	
	
	
}
