package com.esuizhen.cloudservice.user.dao;

import com.westangel.common.bean.user.ConfHospitalWX;

/**
 * <p>Title:ConfHospitalWXDao</p>
 * <p>Description:医院微信公众号配置信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年6月7日 下午7:21:23
 */
public interface ConfHospitalWXDao {

	/**
	 * <p>Title:findByHospitalId</p>
	 * <p>Description:通过医院ID获取医院微信公众号配置信息数据</p>
	 * @author YYCHEN
	 * @date 2016年6月7日 下午7:22:18
	 * @param hospitalId
	 * @return
	 */
	ConfHospitalWX findByHospitalId(Integer hospitalId);
	
	/**
	 * <p>Title:findByProductId</p>
	 * <p>Description:通过产品ID获取医院微信公众号配置信息数据</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午3:40:02
	 * @param productId
	 * @return
	 */
	ConfHospitalWX findByProductId(Integer productId);
}
