/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.bean;<br/>  
 * <b>文件名：</b>SystemArticleTitleListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月22日上午10:16:23<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.bean;

import com.westangel.common.bean.sys.TagInfo;

import java.util.List;

/**
* @ClassName: SystemArticleTitleListReq
* @Description: 
* @author lichenghao
* @date 2016年7月22日 上午10:16:23  
*/
public class KnowledgeTitleListReq {
	//关键词
	private String keyword;
	//标签
	private String tag;
	//病种
	private Integer diseaseTypeId;
	//医生
	private Long doctorId;
	//标签Id
	private Integer tagId;

	private Long patientId;

	private List<TagInfo> tags;
	//分页索引
	private Integer pageSize=0;
	//每页数量
	private Integer num=10;
	//是否随机
	private Integer isRandom=0;

	private String ruleId;

	private String sourceType;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getIsRandom() {
		return isRandom;
	}

	public void setIsRandom(Integer isRandom) {
		this.isRandom = isRandom;
	}

	public List<TagInfo> getTags() {
		return tags;
	}

	public void setTags(List<TagInfo> tags) {
		this.tags = tags;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
}
