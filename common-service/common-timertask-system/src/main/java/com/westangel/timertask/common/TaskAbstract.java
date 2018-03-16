package com.westangel.timertask.common;

import java.util.Comparator;
import java.util.List;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

/**
* @ClassName: TaskAbstract 
* @Description: 任务抽象方法
* @author wang_hw
* @date 2016年1月13日 下午6:29:39
 */
public abstract class TaskAbstract implements IScheduleTaskDealSingle<Long>
{
	public Comparator<Long> getComparator()
	{
		return null;
	}

	public List<Long> selectTasks(String arg0, String arg1, int arg2, List<TaskItemDefine> arg3, int arg4) throws Exception
	{
//		job();
		return null;
	}

	public boolean execute(Long arg0, String arg1) throws Exception
	{
		return true;
	}
	
	public abstract void job();

}
