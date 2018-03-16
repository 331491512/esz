 package com.esuizhen.client.sync.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.client.sync.bean.TBatchDataResultDetailInfo;
import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.dao.DoctorDao;
import com.esuizhen.client.sync.dao.UserDao;
import com.esuizhen.client.sync.dao.sc.SyncResultHistoryClientDao;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.service.DataSyncService;
import com.esuizhen.client.sync.util.ClientRequestServerUtil;
import com.esuizhen.client.sync.util.GetModel;
import com.esuizhen.client.sync.util.PushDataTransfer;
import com.esuizhen.client.sync.util.SyncResultUtil;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Component
public class DoctorServiceImpl implements DataSyncService {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SyncResultHistoryClientDao syncResultHistoryClientDao;
	
	
	@Transactional
	@Override
	public int pushDataToServer(TBatchDetailInfo detailInfo) {
		int totalnum = 0;
		try {
			List<LinkedHashMap> l_doctor = doctorDao.getBatchSyncDoctor(detailInfo);
			totalnum = l_doctor.size();

			if (l_doctor.size() > 0) {
				// 定义userids,用来接收与doctor关联的User
				String userIds = "";

				for (LinkedHashMap d : l_doctor) {
					userIds = userIds + d.get("userId") + ",";
				}
                
				userIds = userIds.substring(0,userIds.length()-1);
				
				List<LinkedHashMap> l_u = doctorDao.getBatchSyncUserByDoctorUserId(userIds);

				if (l_u.size() > 0 && l_doctor.size() == l_u.size()) {
					// -->开始推送医生的用户信息
					// 01封装用户信息
					String u_json_data = PushDataTransfer.transfer(detailInfo.getBatchId(), 100, l_u);

					// 02推送用户信息
					String res1 = ClientRequestServerUtil.pushBatchData(u_json_data);
					TMsgResponse<Object> msg = JsonUtil.toObject(res1, TMsgResponse.class);

					// 判断返回结果
					if (null != msg && msg.getRespCode() == 0) {
						// 03修改user表状态
						//userDao.updateUserSyncflag(userIds + "0");

						// -->开始推送医生信息
						// 01封装医生信息
						String d_json_data = PushDataTransfer.transfer(detailInfo.getBatchId(), 101, l_doctor);

						// 02推送医生信息
						String res2 = ClientRequestServerUtil.pushBatchData(d_json_data);
						TMsgResponse<Object> msg2 = JsonUtil.toObject(res2, TMsgResponse.class);
						if (null != msg2 && msg2.getRespCode() == 0) {
							// 03修改doctor表状态
							String doctorIds = "";

							for (LinkedHashMap d : l_doctor) {
								doctorIds = doctorIds + d.get("doctorId") + ",";
							}
							
							doctorIds = doctorIds.substring(0,doctorIds.length()-1);
							
							doctorDao.updateDoctorSyncflag(doctorIds);
						} else {
							totalnum = -1;
						}

					} else {
						totalnum = -1;
					}
				}else{
					totalnum = -1;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			totalnum = -1;
		}
		return totalnum;
	}
	
	@Transactional
	@Override
	public int getResultFromServer(TBatchDetailInfo detailInfo) {
		int totalnum = 0;
		try {
			// 拼接推送信息
			String json_data = PushDataTransfer.transfer2(detailInfo);
	        // 获取推送结果
			String res = ClientRequestServerUtil.getBatChDataResult(json_data);
			
		    TMsgResponse<Object> msg = JsonUtil.toObject(res, TMsgResponse.class);
			
			if(null!=msg && msg.getRespCode()==0){
				List<Object> l_tBatchDataResultInfo = (List<Object>) msg.getResult();
				totalnum = l_tBatchDataResultInfo.size();
				
				if(l_tBatchDataResultInfo.size()>0){
					for (Object obj : l_tBatchDataResultInfo) {
						TBatchDataResultInfo result = SyncResultUtil.trunkToSyncResult(obj, detailInfo);
						doctorDao.updateSyncResult(result);
						syncResultHistoryClientDao.insertResult(result);
					}
				}
			
			}else{
				totalnum=-1;
			}
		} catch (Exception e) {
			LogUtil.logError.error("<ERROR>---医生同步结果获取失败==>>>:"+e.getMessage());
			e.printStackTrace();
			totalnum=-1;
		}
		return totalnum;
	}

}
