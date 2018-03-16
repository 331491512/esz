package com.westangel.common.bean.message.structuration;

import java.io.Serializable;
import java.util.List;

/**
 * 简单图文消息
 * @author Daloong
 * @date  2016/1/16
 *
 */
public class TPicTextMsg implements Serializable {
	private static final long serialVersionUID = 1L;
				
		private String description; //描述
		
		private List<String> picUrl; //图片地址列表

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
		 * @return the picUrl
		 */
		public List<String> getPicUrl() {
			return picUrl;
		}

		/**
		 * @param picUrl the picUrl to set
		 */
		public void setPicUrl(List<String> picUrl) {
			this.picUrl = picUrl;
		}
		
		

		
}
