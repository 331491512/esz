package com.westangel.commonservice.push.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.commonservice.push.model.EventInfoHistory;

/**
* @ClassName: EventInfoHistoryDao 
* @Description: 推送历史数据操作接口
* @author wang_hw
* @date 2016年2月17日 下午3:53:00
 */
public interface EventInfoHistoryDao{
	
	/**
	 * @author wang_hw
	 * @title :insertEventInfoHistory
	 * @Description:保存推送历史
	 * @return void
	 * @date 2016年2月17日 下午3:53:33
	 */
	public void insertEventInfoHistory(EventInfoHistory eventInfoHistory);
	
	/**
	 * @author wang_hw
	 * @title :updateEventInfoHistory
	 * @Description:修改推送历史
	 * @return void
	 * @date 2016年2月17日 下午3:53:49
	 */
	public void updateEventInfoHistory(EventInfoHistory eventInfoHistory);
	
	/**
	 * @author wang_hw
	 * @title :deleteEventInfoHistory
	 * @Description:删除操作历史
	 * @return void
	 * @date 2016年2月17日 下午3:54:08
	 */
	public void deleteEventInfoHistory(Long id);
	
	/**
	 * @author wang_hw
	 * @title :queryEventInfoHistory
	 * @Description:查询操作历史
	 * @return EventInfoHistory
	 * @date 2016年2月17日 下午3:54:19
	 */
	public EventInfoHistory queryEventInfoHistory(Long id);
	
	/**
	 * @author wang_hw
	 * @title :selectEventInfoHistoryList
	 * @Description:查询推送历史
	 * @return List<EventInfoHistory>
	 * @date 2016年2月17日 下午5:18:31
	 */
	public List<EventInfoHistory> selectEventInfoHistoryList(@Param("businessId")Integer businessId, @Param("productId")Integer productId, @Param("userId")Long userId);
	
	public void updateEventInfoHistoryByPushInfo(@Param("businessId")Integer businessId, @Param("productId")Integer productId, @Param("userId")Long userId);
}
