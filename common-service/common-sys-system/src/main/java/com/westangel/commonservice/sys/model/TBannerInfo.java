/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.model;<br/>  
 * <b>文件名：</b>TBannerInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日下午4:53:57<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.model;
/** 
* @ClassName: TBannerInfo
* @Description: Banner信息
* @author lichenghao
* @date 2015年12月17日 下午4:53:57  
*/
public class TBannerInfo {
	
	//图片URL
	private String imageUrl;
	//点击图片进入链接
	private String contentLink;
	//分享标题
	private String shareTitle;
	//分享描述
	private String shareText;
	//分享缩略图
	private String shareThumbnail;
	//bannerId
	private String bannerId;
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getContentLink() {
		return contentLink;
	}
	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareText() {
		return shareText;
	}
	public void setShareText(String shareText) {
		this.shareText = shareText;
	}
	public String getShareThumbnail() {
		return shareThumbnail;
	}
	public void setShareThumbnail(String shareThumbnail) {
		this.shareThumbnail = shareThumbnail;
	}
	public String getBannerId() {
		return bannerId;
	}
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}
}
