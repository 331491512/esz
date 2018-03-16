package com.westangel.commonservice.multimedia.util.image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;

import com.westangel.common.util.LogUtil;

import net.coobird.thumbnailator.Thumbnails;

/**
* @ClassName: ImageHandlerUtil 
* @Description: 图片处理工具类
* @author wang_hw
* @date 2015年12月17日 下午5:03:05
 */
public class ImageHandlerUtil
{
	/**
	 * 线程池
	 */
	public static ExecutorService exec = Executors.newFixedThreadPool(3);

	/**
	 * 线程互斥
	 */
	public static Semaphore semp = new Semaphore(1);

	/**
	 * 任务列表
	 */
	public static List<File> taskList = new ArrayList<File>();

	/**
	 * @author wang_hw
	 * @title :addTask
	 * @Description:添加任务
	 * @return void
	 * @date 2015年12月17日 下午5:03:30
	 */
	public static void addTask(File file)
	{
		try {
			semp.acquire();
			taskList.add(file);
			semp.release();
			for(int i=0; i<taskList.size(); i++)
			{
				exec();
			}
		} catch (InterruptedException e) {
			LogUtil.logError.error("compress image error:"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @author wang_hw
	 * @title :exec
	 * @Description:执行任务
	 * @return void
	 * @date 2015年12月17日 下午5:03:41
	 */
	public static void exec()
	{
		exec.execute(new Runnable()
		{
			@Override
			public void run()
			{
				LogUtil.log.info("当前图片列表："+taskList.toString());
				File file = null;
				try {
					semp.acquire();
					if(taskList.size()>0)
					{
						file = taskList.get(0);
						taskList.remove(0);
						LogUtil.log.info("当前压缩图片："+file.getAbsolutePath());
					}
					semp.release();

					if(file==null)
					{
						return;
					}
					//生成小图标
					String fileName = file.getAbsoluteFile().toString();
					fileName = fileName.replace(getFileSuffix(fileName), "_ico"+getFileSuffix(fileName));
					
					//临时图片
					String tmpFileName = fileName+getFileSuffix(fileName);
					File tmpFile = new File(tmpFileName);
					FileUtils.copyFile(file, tmpFile);
					Thumbnails.of(tmpFile).size(200, 200).toFile(fileName);
					tmpFile.delete();
					
				} catch (Exception e) 
				{
					e.printStackTrace();
					try{semp.acquire(); taskList.add(file); semp.release(); } catch (Exception e1) { }
				}

			}
		});
	}

	/**
	 * @author wang_hw
	 * @title :taskExec
	 * @Description:添加任务并执行任务
	 * @return void
	 * @date 2015年12月17日 下午5:03:57
	 */
	public static void taskExec(File file)
	{
		addTask(file);
	}

	/**
	 * @author wang_hw
	 * @title :getFileSuffix
	 * @Description:获取文件后缀
	 * @return String
	 * @date 2015年12月17日 下午5:04:18
	 */
	public static String getFileSuffix(String fileName)
	{
		if(fileName==null || fileName.length()<1 || StringUtils.countMatches(fileName, ".") < 1)
		{
			return null;
		}
		return  fileName.substring(fileName.lastIndexOf("."));
	}
}
