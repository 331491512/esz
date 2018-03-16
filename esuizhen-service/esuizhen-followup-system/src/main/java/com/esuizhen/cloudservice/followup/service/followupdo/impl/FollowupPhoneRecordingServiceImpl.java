package com.esuizhen.cloudservice.followup.service.followupdo.impl;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javazoom.jl.decoder.Bitstream;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.TelephoneRecordingReq;
import com.esuizhen.cloudservice.followup.dao.followupdo.FollowupPhoneCallRecordDao;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupPhoneRecordingService;

@Service(value = "followupPhoneRecordingService")
@Transactional
public class FollowupPhoneRecordingServiceImpl implements FollowupPhoneRecordingService {
	@Value("${phone.call.record.path}")
	private String path;

	@Value("${phone.call.record.url}")
	private String url;

	@Value("${conn.time}")
	private String connTime;

	@Value("${read.time}")
	private String readTime;

	@Value("${inner.phone.record.url}")
	private String innerUrl;

	@Autowired
	private FollowupPhoneCallRecordDao followupPhoneCallRecordDao;

	@Override
	public int savePhoneRecording(TelephoneRecordingReq phoneCallReq) {
		String origFileName = phoneCallReq.getOrigFileName();
		if (StringUtils.isNotEmpty(origFileName)) {
			phoneCallReq.setPhoneCallPath(path + origFileName);
			phoneCallReq.setPhoneCallUrl(url + origFileName);
		}
		return followupPhoneCallRecordDao.insertPhoneCallRecord(phoneCallReq);
	}

	@Override
	public int updatePhoneCallRecord(TelephoneRecordingReq phoneCallReq) {
		return followupPhoneCallRecordDao.updatePhoneCallRecord(phoneCallReq);
	}

	@Override
	public List<TelephoneRecordingReq> queryFollowupPhoneRecordList(TelephoneRecordingReq phoneCallReq) {
		List<TelephoneRecordingReq> phoneRecordLsit = followupPhoneCallRecordDao.queryFollowupPhoneRecordList(phoneCallReq);
		List<TelephoneRecordingReq> rList = new ArrayList<TelephoneRecordingReq>();
		for (int i = 0; i < phoneRecordLsit.size(); i++) {
			// ==========================================
			if (phoneRecordLsit.get(i).getDuration() == null) {
				if (StringUtils.isNotEmpty(phoneRecordLsit.get(i).getPhoneCallUrl())) {
					try {
						String url = phoneRecordLsit.get(i).getPhoneCallUrl();
						if(StringUtils.isNotEmpty(innerUrl)){
							if(url.indexOf(innerUrl) <= 0){
								int start = url.indexOf("phoneCallRecord");
								url = url.substring(start);
								url = innerUrl+url;
							}
						}
						URL urlfile = new URL(url);
						HttpURLConnection con = (HttpURLConnection) urlfile.openConnection();
						if (StringUtils.isNotEmpty(connTime)) {
							con.setConnectTimeout(Integer.parseInt(connTime));
						}
						if (StringUtils.isNotEmpty(readTime)) {
							con.setReadTimeout(Integer.parseInt(connTime));
						}
						int code = con.getResponseCode();
						if (code == 200) {
							int b = con.getContentLength();// 得到音乐文件的总长度
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							Bitstream bt = new Bitstream(bis);
							javazoom.jl.decoder.Header h = bt.readFrame();
							int time = (int) h.total_ms(b);
							phoneRecordLsit.get(i).setDuration(time * 2 / 1000);
							TelephoneRecordingReq updateDuration = new TelephoneRecordingReq();
							updateDuration.setPhoneCallRecordId(phoneRecordLsit.get(i).getPhoneCallRecordId());
							updateDuration.setDuration(time * 2 / 1000);
							rList.add(phoneRecordLsit.get(i));
							followupPhoneCallRecordDao.updatePhoneCallRecord(updateDuration);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				rList.add(phoneRecordLsit.get(i));
			}
			// ==========================================
		}
		return rList;
	}
}
