package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.bean.ExpressAddressReq;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Nidan on 2017年05月10 上午 11:15
 */
public interface ExpressAddressDao extends CommonDao<ExpressAddressReq> {

    public void deleteExpressAddressById(ExpressAddressReq req);

    void modifyDefaultByUserId(Long userId);

    void modifyDefaultByCreateTime(Long userId);

    void modifyDefaultByCreateTimeNotIn(@Param("addressId") String addressId, @Param("userId") Long userId);
}
