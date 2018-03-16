package com.westangel.common.util;

import com.github.pagehelper.PageInfo;
import com.westangel.common.bean.Page;

/**
 * 
* @ClassName: PageUtil 
* @Description: 分页工具类
* @author wang_hw
* @date 2015年12月10日 上午10:20:07
 */
public class PageUtil
{
	/**
	 * 
	 * @author wang_hw
	 * @title :returnPage
	 * @Description:将数据库返回的数据，转换为统一的前台Page对象
	 * @return Page
	 * @date 2015年12月10日 上午10:20:18
	 */
	public static Page returnPage(com.github.pagehelper.Page<?> p)
	{
		PageInfo<?> pageInfo = new PageInfo(p);
		Page page = new Page();
		page.setCurrPage(p.getPageNum()-1);
		page.setTotalNum((int)p.getTotal());
		page.setTotalPage(p.getPages());
		page.setDataList(p);
		page.setCurrSize(pageInfo.getSize());
		return page;
	}
}
