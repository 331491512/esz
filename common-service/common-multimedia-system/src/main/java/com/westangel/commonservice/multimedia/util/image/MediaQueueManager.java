package com.westangel.commonservice.multimedia.util.image;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class MediaQueueManager {
	
	private MediaQueueManager(){}
	private static MediaQueueManager mediaQueueManager;
	public static MediaQueueManager getMediaQueueManager(){
		if(mediaQueueManager == null){
			mediaQueueManager = new MediaQueueManager();
		}
		return mediaQueueManager;
	}

	private Queue<MediaObject> mediaQueue = new ConcurrentLinkedQueue<MediaObject>();
	
	public boolean push(MediaObject mediaObject){
		return mediaQueue.add(mediaObject);
	}
	
	public MediaObject pull(){
		return mediaQueue.poll();
	}
	
	public boolean isEmpty(){
		return mediaQueue.peek() == null ? true : false;
	}
	
	
}
