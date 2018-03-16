package com.westangel.common.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:ConfHospitalWX</p>
 * <p>Description:医院微信公众号配置bean</p>
 * @author YYCHEN
 * @date 2016年6月7日 下午7:17:48
 */
public class ConfHospitalWX implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Long id;
	//医院ID
	private Integer hospitalId;
	//微信公众号ID
	private Integer weixinId;
	//服务名
	private String serviceName;
	//微信公众号名
	private String weixinName;
	//产品ID
	private Integer productId;
	//
	private String remark;
	//是否启用
	private Integer enableFlag;
	//记录创建时间
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWeixinName() {
		return weixinName;
	}
	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getWeixinId() {
		return weixinId;
	}
	public void setWeixinId(Integer weixinId) {
		this.weixinId = weixinId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(Integer enableFlag) {
		this.enableFlag = enableFlag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
