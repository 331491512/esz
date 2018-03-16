/**
 * 
 */
package com.westangel.common.bean.message.structuration;

import java.io.Serializable;
import java.util.List;

/**
 * button类型的消息定义
 * @author bigdragon
 * @date   2016/1/6
 *
 */
public class TButtonMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;//标题
	
	private String price; //价格。 这个字段如果有，特殊显示
	
	private String state; //状态：dakuan(已打款); tuikuan(退款)。这个字段如果有，特殊显示
	
	private String description; //描述
	
	private List<TButtonItemInfo> button;      //button列表。最多支持4个竖排；2个横排
	
	private String  style;  //vertical | horizontal 对齐方式:vertical:竖排，从上到下； horizontal:横排，从左到右

	private TBottomInfo     bottom;      //底部

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the button
	 */
	public List<TButtonItemInfo> getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(List<TButtonItemInfo> button) {
		this.button = button;
	}

	/**
	 * @return the bottom
	 */
	public TBottomInfo getBottom() {
		return bottom;
	}

	/**
	 * @param bottom the bottom to set
	 */
	public void setBottom(TBottomInfo bottom) {
		this.bottom = bottom;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
}
