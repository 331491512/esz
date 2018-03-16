package com.esuizhen.cloudservice.research.timing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;

/**
 * <p>Title:TimerTask</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年11月12日 下午12:11:04
 */
@Service(value = "timerTask")
public class TimerTask {
	@Autowired
	private ProjectDao projectDao;
	
	//@Scheduled(cron = "0 30 13 * * ?")
	public void scanning() {
		this.endProject();
	}
	
	/**
	 * <p>Title:endProject</p>
	 * <p>Description:更新专题的结束时间</p>
	 * @author YYCHEN
	 * @date 2016年11月12日 下午12:27:25
	 */
	private void endProject(){
		this.projectDao.updateProjectEndState();
	}
}
