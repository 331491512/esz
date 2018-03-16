package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalPhotoOcrs;

/**
* @ClassName: EmedicalPhotoOcrsDao 
* @Description: 图片OCR数据操作接口 
* @author wang_hw
* @date 2015年12月15日 上午10:54:44
 */
public interface EmedicalPhotoOcrsDao{
	
	/**
	 * @author wang_hw
	 * @title :insertEmedicalPhotoOcrs
	 * @Description:录入图片信息
	 * @return void
	 * @date 2015年12月15日 上午10:55:04
	 */
	public void insertEmedicalPhotoOcrs(EmedicalPhotoOcrs emedicalPhotoOcrs);
	
	/**
	 * @author wang_hw
	 * @title :insertEmedicalPhotoOcrsList
	 * @Description:OCR批量插入
	 * @return void
	 * @date 2015年12月15日 上午11:22:12
	 */
	public void insertEmedicalPhotoOcrsList(List<EmedicalPhotoOcrs> list);
	
	/**
	 * @author wang_hw
	 * @title :updateEmedicalPhotoOcrs
	 * @Description:修改图片及OCR信息
	 * @return void
	 * @date 2015年12月15日 上午10:55:28
	 */
	public void updateEmedicalPhotoOcrs(EmedicalPhotoOcrs emedicalPhotoOcrs);

	/**
	 * @author wang_hw
	 * @title :deleteEmedicalPhotoOcrs
	 * @Description:删除图片及OCR信息
	 * @return void
	 * @date 2015年12月15日 上午10:55:55
	 */
	public void deleteEmedicalPhotoOcrs(String emrPhotoId);
	
	/**
	 * @author wang_hw
	 * @title :deleteEmedicalPhotoOcrsByEmrId
	 * @Description:根据电子病例ID删除图片及OCR信息
	 * @return void
	 * @date 2015年12月15日 上午10:56:01
	 */
	public void deleteEmedicalPhotoOcrsByEmrId(String emrId);
	
	/**
	 * @author wang_hw
	 * @title :queryEmedicalPhotoOcrs
	 * @Description:根据ID查询OCR及图片信息
	 * @return EmedicalPhotoOcrs
	 * @date 2015年12月15日 上午10:56:59
	 */
	public EmedicalPhotoOcrs queryEmedicalPhotoOcrs(String emrPhotoId);
	
	/**
	 * @author wang_hw
	 * @title :selectEmedicalPhotoOcrsByEmrId
	 * @Description:查询图片及OCR列表
	 * @return List<EmedicalPhotoOcrs>
	 * @date 2015年12月15日 上午10:57:21
	 */
	public List<EmedicalPhotoOcrs> selectEmedicalPhotoOcrsByEmrId(String emrId);
}
