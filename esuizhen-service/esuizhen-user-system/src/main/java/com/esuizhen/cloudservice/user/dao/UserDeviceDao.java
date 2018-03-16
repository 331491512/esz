package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.model.UUserDevice;

/**
 * 
 * @author YYCHEN
 *
 */
public interface UserDeviceDao {

	public int deleteByPrimaryKey(Long id);

	public long insert(UUserDevice record);

	public UUserDevice selectByPrimaryKey(Long id);

	/**
	 * <p>Title: update</p>
	 * <p>Description: 修改设备信息</p>
	 * @date 2016年4月20日 下午5:01:25
	 * @param record
	 * @param role
	 * @param productId
	 * @return
	 */
	public int update(@Param("record")UUserDevice record, @Param("role")Integer role, @Param("productId")Integer productId);
	
	/**
	 * <p>Title:updateUserDevice</p>
	 * <p>Description:更新使用设备的APP编码</p>
	 * @author YYCHEN
	 * @date 2016年5月18日 下午5:11:56
	 * @param luid
	 * @param appVersion
	 * @return
	 */
	public int updateUserDevice(@Param("luid")String luid, @Param("appVersion")String appVersion);
	
	/**
	 * <p>Title: selectByUserId</p>
	 * <p>Description: 通过用户ID和deviceId查找设备</p>
	 * @date 2016年4月20日 下午4:45:29
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public List<UUserDevice> selectByUserIdAndDeviceId(@Param("userId")Long userId, @Param("deviceId")String deviceId);
	
	/**
	 * <p>Title: queryCount</p>
	 * <p>Description: 查询同一台设备的用户记录</p>
	 * @date 2016年4月20日 下午4:17:01
	 * @param userDevice
	 * @param userId
	 * @return
	 */
	public int queryCount(@Param("record")UUserDevice userDevice, @Param("userId")Long userId);

	/**
	 * <p>Title: findByLuid</p>
	 * <p>Description: 通过luid查询设备信息</p>
	 * @date 2016年4月21日 下午6:30:48
	 * @param luid
	 * @param opFlag
	 * @return
	 */
	public UUserDevice findByLuid(@Param("luid")String luid, @Param("opFlag")Integer opFlag);
	
	public List<UUserDevice> searchUserDeviceListByDeviceId(@Param("deviceId")String deviceId, @Param("role")Integer role);
	
	/**
	 * <p>Title:exsitDeviceInfo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月18日 下午5:39:07
	 * @param luid
	 * @return
	 */
	public int exsitDeviceInfo(String luid);
}