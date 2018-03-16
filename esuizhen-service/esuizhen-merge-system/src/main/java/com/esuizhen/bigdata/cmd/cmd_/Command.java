package com.esuizhen.bigdata.cmd.cmd_;

/**
 * Created by fqc 16/11/25.
 * 实际的患者合并业务 合并 撤销 都是对一个目标id进行操作
 * 检索到该id，然后进行业务逻辑的处理
 * 情况  1> 全部业务合并完成
 *      2> 合并到一半失败，此时1. 对之前的操作进行业务回滚。
 *                           2. 对前台相应合并失败，并提示原因
 *
 *      3> 合并完成后，发现合并的不合适,需要给其查看合并内容，想要撤销, 传递id
 */
public interface Command {

    /**
     * 执行合并
     */
    void executeMerge();

    /**
     * 撤销
     */
    void undo();

    /**
     * 重新执行
     */
    void redo();
}