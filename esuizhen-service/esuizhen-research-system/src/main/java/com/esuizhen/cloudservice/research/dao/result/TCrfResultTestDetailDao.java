package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultTestDetail;

/**
 * @ClassName: TCrfResultTestDetailDao
 * @Description: 检验明细结果数据操作接口
 * @author wang_hw
 * @date 2016年5月30日 下午7:09:40
 */
public interface TCrfResultTestDetailDao {
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTestDetail
	 * @Description:检验明细结果保存
	 * @return void
	 * @date 2016年5月30日 下午7:10:05
	 */
	public void insertCrfResultTestDetail(TCrfResultTestDetail crfResultTestDetail);

	/**
	 * @author wang_hw
	 * @title :insertCrfResultTestDetailList
	 * @Description:检验明细结果保存(列表)
	 * @return void
	 * @date 2016年5月31日 上午10:42:24
	 */
	public void insertCrfResultTestDetailList(List<TCrfResultTestDetail> list);

	/**
	 * @author wang_hw
	 * @title :updateCrfResultTestDetail
	 * @Description:检验明细结果修改
	 * @return void
	 * @date 2016年5月30日 下午7:10:11
	 */
	public void updateCrfResultTestDetail(TCrfResultTestDetail crfResultTestDetail);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTestDetail
	 * @Description:检验明细结果删除
	 * @return void
	 * @date 2016年5月30日 下午7:10:14
	 */
	public void deleteCrfResultTestDetail(String crfResultTestDetailId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTestDetailByCrfResultId
	 * @Description:检验结果明细删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:15:09
	 */
	public void deleteCrfResultTestDetailByCrfResultId(String crfResultId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTestDetail
	 * @Description:检验明细结果查询
	 * @return TCrfResultTestDetail
	 * @date 2016年5月30日 下午7:10:18
	 */
	public TCrfResultTestDetail queryCrfResultTestDetail(String crfResultTestDetailId);

	/**
	 * <p>
	 * Title:queryCrfResultTestDetailByTestId
	 * </p>
	 * <p>
	 * Description:通过检验ID查询检验详情数据列表
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月29日 下午2:51:12
	 * @param crfTestResultId
	 * @return
	 */
	public List<TCrfResultTestDetail> queryCrfResultTestDetailByResultId(String crfTestResultId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:13:55
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
