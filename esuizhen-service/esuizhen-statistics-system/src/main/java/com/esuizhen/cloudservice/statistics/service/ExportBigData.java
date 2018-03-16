package com.esuizhen.cloudservice.statistics.service;

import java.io.File;
import java.util.List;
import java.util.Map;

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
     * 导出sql查询出的数据,默认是excel格式，数据量大于设置的最大值，输出为压缩后的格式。
     * @param destFile
     * @param maxRow
     * @param titles
     * @param resultList
     * @param writeWay
     */
    void exportToZip(File destFile,final int maxRow, String titles,List<?> resultList);
    
    void exportToZip(File destFile,String titles,Map<String,List<String>> valuesMap);
}
