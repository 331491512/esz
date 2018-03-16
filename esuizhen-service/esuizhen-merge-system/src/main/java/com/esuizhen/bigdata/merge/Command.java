package com.esuizhen.bigdata.merge;

/**
 * Created by fqc 16/11/25.
 * 合并动作接口
 */
public interface Command {

    /**
     * 执行合并
     */
    void executeMerge() throws Exception;

    /**
     * 撤销
     */
    void undo();

    /**
     * 重新执行
     */
    void redo();
}