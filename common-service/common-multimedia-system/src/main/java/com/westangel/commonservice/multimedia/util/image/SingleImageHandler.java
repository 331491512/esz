package com.westangel.commonservice.multimedia.util.image;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.codec.binary.Base64;

public class SingleImageHandler {
	
	ExecutorService executor;
	int fileNameIndex;
	
	public SingleImageHandler(){
//		new Thread(new OutputFileThread()).start();
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		executor.execute(new OutputFileThread());
//		executor.shutdown();
		executor = Executors.newFixedThreadPool(10);
		fileNameIndex = 0;
	}
	/*
	private byte[] getBodysAndDecode(HttpRequestMessage httpRequestMessage){
		String charset = httpRequestMessage.getHeader("Content-Charset");
		if(charset != null && charset.equals("Base64")){
			return Base64.decodeBase64(httpRequestMessage.getBodys());
		}
		return httpRequestMessage.getBodys();
	}

	@Override
	public HttpRequestMessage handle(HttpRequestMessage httpRequestMessage, HttpResponseMessage httpResponseMessage){
		
		String fileUrl = handleMedia(httpRequestMessage,httpResponseMessage);
		if(fileUrl==null)
		{
			NodeLogger.instance().error("handle single image error: handleMedia() return null.");
			//httpResponseMessage.setBodys(getRspBody(500,"").getBytes());
			return null;
		}
		
		
		NodeLogger.instance().debug("handle image succeed and we will send response 200 ok and the url:"+fileUrl );
		httpResponseMessage.setBodys(getRspBody(200,fileUrl).getBytes());
		return null;
	}
	
	
	
	//return fileUrl. null means false.
	public String handleMedia(HttpRequestMessage httpRequestMessage,HttpResponseMessage httpResponseMessage){
		byte[] fileBytes = getBodysAndDecode(httpRequestMessage);
		String auth = httpRequestMessage.getHeader("Authorization");
		if(auth==null) {
			NodeLogger.instance().error("ERROR in SingleImageHandler.handleMedia(): upload single image failed: header Authorization does not exist!");
			
			httpResponseMessage.setBodys(getRspBody(400,"").getBytes());
			return null;
		}
		String[] authParams = auth.split("[;,]");
		Map<String, String> paramsMap = new HashMap<String, String>();
		for (String string : authParams) {
			String[] data = string.split("=");
			if(data.length != 2){
				continue;
			}
			paramsMap.put(data[0], data[1]);
		}
		String userID = paramsMap.get("userId");
		if(userID == null || userID.length()<=0){
			NodeLogger.instance().error("ERROR in SingleImageHandler.handleMedia(): upload single image failed: userID para does not exist!");
			httpResponseMessage.setBodys(getRspBody(403,"").getBytes());

			return null;
		}
		
		String funcApi = paramsMap.get("funcApi");
		if(funcApi == null || funcApi.length()<=0){
			NodeLogger.instance().error("ERROR in SingleImageHandler.handleMedia(): upload single image failed: funcApi para does not exist!");
			httpResponseMessage.setBodys(getRspBody(400,"").getBytes());
			return null;
		}
	
		//fileName: 帖子序号_UserID_楼层_yyMMddhhmmssnn
		String fileName = paramsMap.get("fileName");
		String thumFileName=fileName;
		if(fileName == null || fileName.length()<=0){
			
			java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddhhmmss");
	        String s = dateFormat.format(new Date());
	        fileNameIndex++;
	        if(fileNameIndex>100000) fileNameIndex = 0;
	        fileName =  funcApi + "_" + userID +"_"+ s + fileNameIndex + "_b.jpg";
	        thumFileName = funcApi + "_" + userID +"_"+ s + fileNameIndex + ".jpg";
		}
		else{
			thumFileName = fileName+".jpg";
			fileName = fileName+"_b.jpg";
		}
			
		MediaObject mediaObject = new MediaObject();
		mediaObject.content = fileBytes;
		mediaObject.fileName = fileName;
		mediaObject.filePath = MediaConfig.getMediaConfig().rootDir+getImageSaveDir(funcApi);
		
		MediaQueueManager.getMediaQueueManager().push(mediaObject);
		NodeLogger.instance().debug("Begin to call MediaOutputThread to save image to file. fileName="+fileName+"...");
		try {
			executor.execute(new MediaOutputThread());
		} catch (Exception e) {
			e.printStackTrace();
			NodeLogger.instance().error("ERROR in SingleImageHandler.handleMedia(): run save image thread error!!");
			httpResponseMessage.setBodys(getRspBody(500,"").getBytes());
			return null;
		}
		return MediaConfig.getMediaConfig().urlRoot +getImageSaveDir(funcApi) +"/" + thumFileName;
	}

	public boolean isSingleImsageMedia(HttpRequestMessage httpRequestMessage){
		return httpRequestMessage.getRequestPath().equals("/system/pic/upload");
	}
	
	private String getRspBody(int respCode,String picUrl){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{");
		stringBuffer.append("\"respCode\":" + respCode);
		if(!picUrl.isEmpty()){
			stringBuffer.append(",\"picUrl\":\""+picUrl+"\"");
			
		}
		stringBuffer.append("}");
		
		return stringBuffer.toString();
	
		
	}
	
	private String getImageSaveDir(String funcApi){
		if(funcApi==null || funcApi.isEmpty()) return "/other";
		if(funcApi.equals("TTopicRichPublish") || funcApi.equals("TTopicRichReply")) return "/topic";
		
		return "/other";
	}
	*/
}
