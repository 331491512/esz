package com.westangel.commonservice.sms.model.yixintong;

/** 
 * @ClassName: Item 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yzq 
 * @date Jul 17, 2015 4:43:07 PM
 */
public class SmsItem {
    
    private String content;
    private String fromMobile;
    private String recTime;
    
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFromMobile() {
		return fromMobile;
	}
	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}
	public String getRecTime() {
		return recTime;
	}
	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}
    
    public SmsItem(){}
    public SmsItem(Item item){
    	if(item!=null){
    		this.fromMobile = item.getFrom_mobile();
    		this.recTime = item.getRec_time();
    		this.content = item.getContent();
    	}
    }
}
