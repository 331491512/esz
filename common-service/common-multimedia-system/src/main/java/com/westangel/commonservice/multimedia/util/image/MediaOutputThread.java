package com.westangel.commonservice.multimedia.util.image;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MediaOutputThread implements Runnable {

	private final static long SLEEP_TIME_MAX = 30; //seconds
	private final static long SLEEP_TIME_MIN = 1; //seconds
	
	private long sleepTime;
	private ImageThum imageThum;
	
	public MediaOutputThread(){
		sleepTime = SLEEP_TIME_MIN;
		imageThum = new ImageThum();
	}
	
	@Override
	public void run() {
		MediaQueueManager mediaQueueManager = MediaQueueManager.getMediaQueueManager();
		MediaObject mediaObject;
		while(true){
			try {
				boolean isWait = mediaQueueManager.isEmpty();
				if(isWait){
					sleepTime ++;
					loopWait();
					continue;
				}
				mediaObject = mediaQueueManager.pull();
				if(mediaObject == null){
					loopWait();
					continue;
				}
				try {
					imageThumAndAllWrite(mediaObject);
					sleepTime = SLEEP_TIME_MIN;
				} catch (IOException e) {
					e.printStackTrace();
					//logger.error("ERROR when write image: "+e.getMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
				//logger.error("ERROR when write image: "+e.getMessage());
			}
		}
	}
	
	public void imageThumAndAllWrite(MediaObject mediaObject) throws IOException{
		MediaObject thumObject = null;
		try {
			thumObject = imageThum.thumbnail(mediaObject);
		} catch (IOException e) {
			e.printStackTrace();
			//logger.debug("MediaOutputThread.imageThumAndAllWrite() ERROR! create image thumbnail file failed:"
			//		+thumObject.fileName);

		}
		write(mediaObject);
		if(thumObject != null){
			write(thumObject);
			//logger.debug("MediaOutputThread.imageThumAndAllWrite(): Ok! write image thumbnail file succeed. file:"
			//		+thumObject.fileName);

		}
	}

	public void write(MediaObject mediaObject) throws IOException {
		File fileDir = new File(mediaObject.filePath);
		if(!fileDir.isDirectory()){
			boolean mkdirStatus = fileDir.mkdirs();
			if(!mkdirStatus){
				//logger.debug("MediaOutputThread.write() ERROR! create dir failed. image file:"
				//		+fileDir.getPath()+"/"+mediaObject.fileName);
			
				System.err.println("ERROR! 创建文件存储目录失败！");
				return;
			}
		}
		File file = new File(fileDir, mediaObject.fileName);
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
		outputStream.write(mediaObject.content);
		//logger.debug("MediaOutputThread.write(): Ok! write image file succeed. file:"
		//		+fileDir.getPath()+"/"+mediaObject.fileName);
		outputStream.close();
	}
	
	
	public void loopWait(){
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
			if(sleepTime > SLEEP_TIME_MAX){
				sleepTime = SLEEP_TIME_MIN;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
