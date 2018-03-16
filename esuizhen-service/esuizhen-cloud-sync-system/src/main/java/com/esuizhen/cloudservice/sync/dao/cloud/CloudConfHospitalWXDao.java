package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.user.ConfHospitalWX;

/**
 * <p>Title:CloudConfHospitalWXDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月17日 下午2:38:15
 */
public interface CloudConfHospitalWXDao {
	/**
	 * <p>Title:findByProductId</p>
	 * <p>Description:通过医院ID获取医院微信公众号配置信息数据</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午3:40:02
	 * @param productId
	 * @return
	 */
	ConfHospitalWX findByHospitalId(Long hospitalId);
}
