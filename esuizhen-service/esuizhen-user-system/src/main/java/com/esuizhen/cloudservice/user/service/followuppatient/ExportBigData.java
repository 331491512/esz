package com.esuizhen.cloudservice.user.service.followuppatient;

import java.io.File;
import java.util.List;

public interface ExportBigData {
  
    
	/**
	 * 导出sql查询出的数据,默认是excel格式，数据量大于设置的最大值，输出为压缩后的格式。
	 * @param maxRow
	 * @param resultList
	 * @param destFile
	 * @param titles 头字段对应的中文字段，即excel标题显示的值
	 * @param titleFields 头字段
	 * @param writeWay 写入方式
	 */
    public void exportToZip(final int maxRow, List<?> resultList,File destFile,List<String> titles,List<String> titleFields,int writeWay);
    
    /**
     * 
     * @author lichenghao
     * @title :exportToZip
     * @Description:导出sql查询出的数据,默认是excel格式，数据量大于设置的最大值，输出为压缩后的格式。
     * @return void
     * @date 2016年8月30日 上午9:21:14
     */
    void exportToZip(File destFile,final int maxRow, String titles,List<?> resultList);
    
    /**
     * 
     * @author lichenghao
     * @title :exportToZip
     * @Description:导出文件并压缩
     * @return void
     * @date 2016年8月30日 下午12:09:49
     */
	public void exportToZip(final int maxRow, List<?> resultList,File destFile,String[] titleFields);
}
