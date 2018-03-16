package com.esuizhen.cloudservice.user.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.dao.followuppatient.FollowupPatientDao;
import com.esuizhen.cloudservice.user.followuppatient.util.FileSuffixEnum;
import com.esuizhen.cloudservice.user.followuppatient.util.FileUtil;
import com.westangel.common.util.LogUtil;

/** 
 * @ClassName: ExportUntil.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月27日
 */
public interface ExportUtilService {

	//模拟分布式导出
		public String exportFile(final String sql,String outFilePath,String[] heads,final String[] columns,String fileName);

}
