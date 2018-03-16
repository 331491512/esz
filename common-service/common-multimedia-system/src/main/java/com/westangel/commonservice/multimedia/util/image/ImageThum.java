package com.westangel.commonservice.multimedia.util.image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


import net.coobird.thumbnailator.Thumbnails;

public class ImageThum {
	
	public final static int THUM_IMAGE_SIZE_MAX = 10 * 1000; //10K
	public final static int SCALE_ZOOM_COUNT_MAX = 2;
	
	/**
	 * 生成图片的缩略图，
	 * 缩小50%，如果还大于<code>THUM_IMAGE_SIZE_MAX</code>值的话，
	 * 继续循环缩放，每次缩放80%
	 * 循环退出条件：大小小于<code>THUM_IMAGE_SIZE_MAX</code>值
	 * 				 大于<code>SCALE_ZOOM_COUNT_MAX</code>次数
	 * 				 图片大小不发生变化
	 * @param mediaObject
	 * @return
	 * @throws IOException
	 */
	public MediaObject thumbnail(MediaObject mediaObject) throws IOException{
		ByteArrayInputStream inputStream = new ByteArrayInputStream(mediaObject.content);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			Thumbnails.of(inputStream)
				.scale(0.5f)  //缩小50%  
				.outputFormat("jpg")
				.toOutputStream(outputStream);
			inputStream.close();
			//
			System.out.println(" first, output size: " + outputStream.size());
			int loopCount = 0;
			while(outputStream.size() > THUM_IMAGE_SIZE_MAX && loopCount <= SCALE_ZOOM_COUNT_MAX){
				loopCount++;
				//
				System.out.println("output size: " + outputStream.size());
				byte[] inputByte = outputStream.toByteArray();
				outputStream.reset();
				System.out.println("reset output size: " + outputStream.size());
				Thumbnails.of(new ByteArrayInputStream(inputByte))
					.scale(0.8f) 
					.outputFormat("jpg")
					.toOutputStream(outputStream);
				//图片不变小时，退出循环
				if( outputStream.size() >= inputByte.length){
					break;
				}
			}
			byte[] b = outputStream.toByteArray();
			outputStream.close();
			MediaObject mediaObjectThum = new MediaObject();
			mediaObjectThum.filePath = mediaObject.filePath;
			String fileName = mediaObject.fileName;
			int bigIndex = fileName.lastIndexOf("_b.");
			StringBuffer thumFileName = new StringBuffer();
			if(bigIndex<0){
				//如果原图不包括_b，那么，使用_s后缀作为缩略图文件名。因为需要和原图文件名有区别
				thumFileName.append(fileName.substring(0, fileName.lastIndexOf(".")));
				thumFileName.append("_s.jpg");
				mediaObjectThum.fileName = thumFileName.toString();
			}
			else{
				//如果原图（大图）包括_b，那么去掉_b，作为缩略图的文件名
				thumFileName.append(fileName.substring(0, bigIndex));
				thumFileName.append(".jpg");
				mediaObjectThum.fileName = thumFileName.toString();	
			}
			mediaObjectThum.content = b;
			return mediaObjectThum;
		} finally {
			if(inputStream != null) inputStream.close();
			if(outputStream != null) outputStream.close();
		}
		
	}
}
