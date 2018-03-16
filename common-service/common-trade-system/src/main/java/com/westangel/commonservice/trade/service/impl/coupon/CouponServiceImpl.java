/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.coupon;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.CouponTemplateInfoGetReq;
import com.westangel.common.bean.trade.CouponTemplateReq;
import com.westangel.common.bean.trade.TCouponTemplateDetailInfo;
import com.westangel.common.bean.trade.TCouponTemplateInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.AccountService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.CouponReq;
import com.westangel.commonservice.trade.bean.TCouponInfo;
import com.westangel.commonservice.trade.dao.CouponDao;
import com.westangel.commonservice.trade.model.coupon.CouponInfo;
import com.westangel.commonservice.trade.model.coupon.CouponTemplateInfo;
import com.westangel.commonservice.trade.service.coupon.CouponService;

/**
 * @author chenghao
 * @date  2016年6月29日 下午2:30:16
 */
@Service
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CouponDao dao;
	@Autowired
	private AccountService accountService;
	/* (non-Javadoc)
	 * @see com.westangel.common.service.CouponInnerService#createCouponTemplate(com.westangel.common.bean.trade.CouponTemplateReq)
	 */
	@Override
	@Transactional
	public TMsgResponse<Object> createCouponTemplate(CouponTemplateReq req) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		try{
			req.setCouponTemplateId(GeneralUtil.generateUniqueID("CTEM"));
			dao.createCouponTemplet(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/* (non-Javadoc)
	 * @see com.westangel.common.service.CouponInnerService#modifyCouponTemplate(com.westangel.common.bean.trade.CouponTemplateReq)
	 */
	@Override
	@Transactional
	public TMsgResponse<Object> modifyCouponTemplate(CouponTemplateReq req) {
		// TODO Auto-generated method stub
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		try{
			dao.modifyCouponTemplet(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/* (non-Javadoc)
	 * @see com.westangel.common.service.CouponInnerService#initCoupon(com.westangel.common.bean.trade.CouponTemplateReq)
	 */
	@Override
	@Transactional
	public TMsgResponse<Object> initCoupon(CouponTemplateReq req) {
		// TODO Auto-generated method stub
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		try{
			if(req.getUserIds()==null||req.getUserIds().size()==0)
				throw new EmptyParamExcption("userIds is null");
			if(StringUtils.isEmpty(req.getCouponTemplateId()))
				throw new EmptyParamExcption("couponTemplateId is null");
			CouponTemplateInfo template = dao.queryCouponTemplateById(req.getCouponTemplateId(),null);
			if(template == null)
				throw new EmptyObjectExcption("template is null or state = 2");
			List<CouponInfo> list = new ArrayList<CouponInfo>();
			for(Long userId : req.getUserIds()){
				list.add(template.initCoupon(userId));
			}
			dao.createCouponList(list);
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1419.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	
	@Override
	public List<TCouponInfo> searchCoupon(CouponReq req) {
		// TODO Auto-generated method stub
		if(req.getOwner()==null)
			throw new EmptyParamExcption("owner is null");
		//将过期抵用券状态置为过期
		dao.updateCoupon(req.getOwner());
		return dao.queryCouponList(req);
	}

	
	@Override
	public void receiveCoupon(CouponReq req) {
		if(req.getOwner()==null)
			throw new EmptyParamExcption("owner is null");
		if(StringUtils.isEmpty(req.getCouponId()))
			throw new EmptyParamExcption("couponId is null");
		CouponTemplateInfo template = dao.queryCouponTemplateById(null,req.getCouponId());
		if(template==null)
			throw new EmptyObjectExcption("couponTemplate is null");
		CouponInfo info = new CouponInfo();
		info.setCouponId(req.getCouponId());
		//修改状态 并加载有效日期
		template.updateCouponState(info, 1);
		info.setOwner(req.getOwner());
		if(modifyCoupon(info)==0)
			throw new EmptyParamExcption("coupon update error couponId="+req.getCouponId()+"  owner="+req.getOwner());
	}
	
	@Override
	public Integer modifyCoupon(CouponInfo coupon){
		return dao.modifyCoupon(coupon);
	}
	/**
	 */
	@Override
	public TMsgResponse<TCouponTemplateDetailInfo> getCouponTemplate(String couponTemplateId) {
		// TODO Auto-generated method stub
		TMsgResponse<TCouponTemplateDetailInfo> msg = new TMsgResponse<TCouponTemplateDetailInfo>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		try{
			if(StringUtils.isEmpty(couponTemplateId))
				throw new EmptyParamExcption(" couponTemplateId is null");
			msg.result = dao.queryCouponTemplate(couponTemplateId);
			if(msg.result==null)
				throw new EmptyObjectExcption(" couponTemplate is null");
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1419.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取抵用券简要信息接口
	 */
	@Override
	public TMsgResponse<List<TCouponTemplateInfo>> getCouponTemplateInfoList(CouponTemplateInfoGetReq req) {
		// TODO Auto-generated method stub
		TMsgResponse<List<TCouponTemplateInfo>> msg = new TMsgResponse<List<TCouponTemplateInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		try{
			msg.result = dao.queryCouponTemplateInfo(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, null));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

}
