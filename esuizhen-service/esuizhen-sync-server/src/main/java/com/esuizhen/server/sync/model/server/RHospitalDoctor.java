package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.esuizhen.server.sync.model.temp.SyncDoctor;
/**
 * Created by Nidan on 2017年03月24 下午 17:01
 */
public class RHospitalDoctor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Long doctorId;

    private Integer hospitalId;

    private String hospitalName;

    private Integer deptId;

    private Integer positionTitle;

    private String staffNo;

    private Date createTime;

    private String doctorUuid;

    private String deptUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(Integer positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid == null ? null : doctorUuid.trim();
    }

    public String getDeptUuid() {
        return deptUuid;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid == null ? null : deptUuid.trim();
    }

  //创建实体
  	public static RHospitalDoctor create(SyncDoctor tempDoctor){
  		RHospitalDoctor rHospitalDoctor = new RHospitalDoctor();
  		BeanUtils.copyProperties(tempDoctor, rHospitalDoctor);
  		return rHospitalDoctor;
  	}
}