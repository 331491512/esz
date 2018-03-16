package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.TCityInfo;
import com.esuizhen.cloudservice.user.model.TMetaInfoNation;
import com.esuizhen.cloudservice.user.model.TMetaInfoNationality;
import com.esuizhen.cloudservice.user.model.TMetaInfoOccupation;
import com.esuizhen.cloudservice.user.model.TMetaInfoRelatives;
import com.esuizhen.cloudservice.user.model.TMetaInfoFaultType;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MetaDao {

	/**
	 * 根据level 和 cityCode获取城市信息
	 * @param param
	 * @return
	 */
	public List<TCityInfo> queryCity(Object param);

	/**
	 * <p>Title:queryMetaInfoNationalityList</p>
	 * <p>Description:查询国籍元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午10:57:27
	 * @param nationalityName
	 * @return
	 */
	public List<TMetaInfoNationality> queryMetaInfoNationalityList(String nationalityName);

	/**
	 * <p>Title:queryMetaInfoNationList</p>
	 * <p>Description:查询民族元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午11:09:09
	 * @param nationName
	 * @return
	 */
	public List<TMetaInfoNation> queryMetaInfoNationList(String nationName);

	/**
	 * <p>Title:queryMetaInfoOccupationList</p>
	 * <p>Description:查询职业元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午11:18:57
	 * @param occupationName
	 * @return
	 */
	public List<TMetaInfoOccupation> queryMetaInfoOccupationList(String occupationName);
	
	public TMetaInfoRelatives queryMetaInfoRelatives(Integer relationId);
	
	public List<TMetaInfoRelatives> queryMetaInfoRelativesList();
	public List<TMetaInfoFaultType> queryMetaInfoMissingTypeList();
	public List<TMetaInfoFaultType> queryMetaInfoInvalidTypeList();
}