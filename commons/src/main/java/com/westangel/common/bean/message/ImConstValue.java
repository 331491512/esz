package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: ImConstValue 
* @Description:常量 
* @author LIPENG
* @date 2015年12月12日 上午10:13:32 
*
 */
public final class ImConstValue implements Serializable {
	private static final long serialVersionUID = 1L;
	public enum chatType {
		ChatTypeUnKown,
		//私聊
		ChatTypePrivate,
	}
	
	//内容类型
	public enum contentType{
		//未知
		ContentUNKNOWNType,
		//文本
		ContentTypeText,
		//图片		
		ContentTypeImage,
		//音频		
		ContentTypeAudio,
		//视频		
		ContentTypeVideo,
		//表情		
		ContentTypeFace,
		//未知		
		ContentTypeLocation,
		//提示		
		ContentTypeTip,
	};	
}
