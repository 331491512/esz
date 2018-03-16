package com.esuizhen.cloudservice.user.service.impl;

import com.esuizhen.cloudservice.user.bean.ExpressAddressReq;
import com.esuizhen.cloudservice.user.dao.ExpressAddressDao;
import com.esuizhen.cloudservice.user.service.ExpressAddressService;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nidan on 2017年05月10 上午 11:14
 */
@Service
public class ExpressAddressServiceImpl implements ExpressAddressService {

    @Autowired
    private ExpressAddressDao expressAddressDao;

    @Override
    public List<ExpressAddressReq> findExpressAddressList(ExpressAddressReq req) {
        if(req.getUserId()==null){
            throw new EmptyParamExcption("userId is not null");
        }
        Map<String,Object> params=new HashMap<>();
        params.put("userId",req.getUserId());
        return expressAddressDao.queryList(params);
    }

    @Override
    public ExpressAddressReq saveExpressAddress(ExpressAddressReq req) {

        if(req.getUserId()==null){
            throw new EmptyParamExcption("userId is not null");
        }
        //添加时返回AddressId
        ExpressAddressReq expressAddress=new ExpressAddressReq();
        if (StringUtils.isBlank(req.getAddressId())){
            if(req.getIsDefault()!=null&&req.getIsDefault().equals(1)){
                expressAddressDao.modifyDefaultByUserId(req.getUserId());
            }/*else{
                Map<String,Object> param=new HashMap<String,Object>();
                param.put("userId",req.getUserId());
                param.put("isDefault",1);
                List<ExpressAddressReq> list=expressAddressDao.queryList(param);
                if(list==null||list.size()==0){
                    req.setIsDefault(1);
                }
            }*/
            req.setAddressId(GeneralUtil.generateUniqueID("EPAD"));
            expressAddressDao.insert(req);
            expressAddress.setAddressId(req.getAddressId());
        }else{
            if(req.getIsDefault()!=null&&req.getIsDefault().equals(1)){
                expressAddressDao.modifyDefaultByUserId(req.getUserId());
            }/*else{
                ExpressAddressReq expressAddress=expressAddressDao.queryOne(req);
                if(expressAddress.getIsDefault().equals(1)){
                    expressAddressDao.modifyDefaultByCreateTimeNotIn(req.getAddressId(),req.getUserId());
                }
            }*/
            expressAddressDao.update(req);
        }
        return expressAddress;
    }

    @Override
    public void deleteExpressAddress(ExpressAddressReq req) {
        if(req.getAddressId()==null||req.getUserId()==null){
            throw new EmptyParamExcption();
        }

        ExpressAddressReq expressAddress=expressAddressDao.queryOne(req);
        if(expressAddress!=null){
            expressAddressDao.deleteExpressAddressById(req);
        }
        if(expressAddress.getIsDefault()!=null&&expressAddress.getIsDefault().equals(1)){
            expressAddressDao.modifyDefaultByCreateTime(req.getUserId());
        }
    }

    @Override
    public ExpressAddressReq findExpressAddress(ExpressAddressReq req) {
        if(req.getAddressId()==null&&(req.getUserId()==null||req.getIsDefault()==null)){
            throw new EmptyParamExcption("when address is null,the userId and isDefault is not null!");
        }

        Map<String,Object> params=new HashMap<>();
        params.put("addressId",req.getAddressId());
        params.put("userId",req.getUserId());
        params.put("isDefault",req.getIsDefault());
        return expressAddressDao.queryOne(params);
    }
}
