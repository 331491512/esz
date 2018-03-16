package com.esuizhen.cloudservice.research.service.result;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;

/**
 * <p>Title:TProjectSubcenterService</p>
 * <p>Description:专题分中心业务层接口</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午4:21:53
 */
public interface TProjectSubcenterService {
	/**
	 * <p>Title:getCreatorProjectSubCenter</p>
	 * <p>Description:获取医生所在的专题分中心，如果分中心不存在，会使用医生的基本信息创建分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午4:25:08
	 * @param crfResultMainInfo
	 * @return
	 */
	public TProjectSubcenter getCreatorProjectSubCenter(TCrfResultMainInfo<?> crfResultMainInfo);

	/**
	 * <p>Title:createProjectSubcenter</p>
	 * <p>Description:创建分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:22:40
	 * @param projectSubcenterDetailInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectAlreadyExistExcption 
	 * @throws UnsupportedEncodingException 
	 * @throws RejectRequestExcption 
	 */
	public boolean createProjectSubcenter(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException, ObjectAlreadyExistExcption, UnsupportedEncodingException, RejectRequestExcption;

	/**
	 * <p>Title:listProjectSubcenter</p>
	 * <p>Description:查询专题下所有的分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:26:50
	 * @param projectId
	 * @return
	 */
	public List<TProjectSubcenter> listProjectSubcenter(String projectId);

	/**
	 * <p>Title:createDefaultProjectSubcenter</p>
	 * <p>Description:根据专题基本信息创建默认分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 下午3:07:15
	 * @param projectSimpleInfo
	 * @return
	 */
	public boolean createDefaultProjectSubcenter(TProjectSimpleInfo projectSimpleInfo);
}
