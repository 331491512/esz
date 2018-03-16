package com.esuizhen.cloudservice.user.service;

import com.esuizhen.cloudservice.user.bean.ExpressAddressReq;

import java.util.List;

/**
 * Created by Nidan on 2017年05月10 上午 10:54
 */
public interface ExpressAddressService {

    /**
     * 获取用户的邮寄地址
     * @param req
     * @return
     */
    public List<ExpressAddressReq> findExpressAddressList(ExpressAddressReq req);

    /**
     * 获取用户邮寄地址详情
     * @param req
     * @return
     */
    public ExpressAddressReq findExpressAddress(ExpressAddressReq req);

    /**
     * 保存用户的邮寄地址
     * @param req
     */
    public ExpressAddressReq saveExpressAddress(ExpressAddressReq req);

    /**
     * 删除用户的邮寄地址
     * @param req
     */
    public void deleteExpressAddress(ExpressAddressReq req);

}
