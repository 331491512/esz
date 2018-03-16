package com.esuizhen.bigdata.cmd.cmd_test04;

/**
 * Interface to implement a Changeable type of action - either undo or redo.
 */
public interface Changeable {


    /**
     * Undoes an action
     */
    public void undo();


    /**
     * Redoes an action
     */
    public void redo();

}
