package com.esuizhen.cloudservice.ehr.service.common;

import java.io.File;
import java.util.List;

public interface ExportBigData {
  
    /** 
     * 导出sql查询出的数据,输出为压缩后的格式 
     *  
     * @param titles 
     *            标题 
     * @param os 
     *            输出流 
     * @param maxRow 
     *            每个excel的最大行数 
     * @param sql 
     *            查询语句 
     * @param sqlParams 
     *            查询参数 
     */  
    public void exportToZip(final int maxRow, List<?> resultList,File destFile);  
}
