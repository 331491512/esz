package com.esuizhen.cloudservice.sync.service;

import java.util.List;

import com.westangel.common.bean.sync.UuidRelationship;

/**
 * UUID映射关系业务逻辑
 * @author YYCHEN
 *
 */
public interface UuidRelationshipService {
	/**
	 * 添加uuid映射关系
	 * @param uuidRelationship
	 * @return
	 */
	public boolean save(UuidRelationship uuidRelationship);
	
	/**
	 * 通过ToB端传入的uuid值查找映射关系
	 * @param uuid
	 * @return
	 */
	public UuidRelationship getByUuid(String uuid);
	/**
	 * 通过ToB端传入的uuid值查找云端对应的uuid值
	 * @param uuid
	 * @return
	 */
	public String getFinalUuidByUuid(String uuid);

	public String getUserId(Long userId);
	
	public Long getDoctorId(String doctorUuid);
	
	public Long getPatientId(String patientUuid);
	
	public Integer getDeptId(String deptUuid);
	
	public List<UuidRelationship> getByFinalUuid(String finalUuid);
}
