package com.esuizhen.bigdata.cmd.cmd_test02;

import junit.framework.TestCase;

public class CommandStackTest extends TestCase {

    CommandStack stack = new CommandStack();

    private String name;
    private int age;

    /**
     * 更新与回滚 name服务
     */
    class EditName extends CommandStack.Command {

        private String oldName = name;
        private String newName;

        public EditName(String newName) {
            super("Update name to " + newName);
            this.newName = newName;
        }

        public void execute() {
            name = newName;
        }

        public void undo() {
            name = oldName;
        }
    }

    /**
     * 更新与回滚 age服务
     */
    class EditAge extends CommandStack.Command {

        private int oldAge = age;
        private int newAge;

        /**
         * @param newAge
         */
        public EditAge(int newAge) {
            super("Update age to " + newAge);
            this.newAge = newAge;
        }

        /**
         * 更新age
         */
        public void execute() {
            age = newAge;
        }

        /**
         * 回退age
         */
        public void undo() {
            age = oldAge;
        }
    }

    public void test_basics() {
        /***环境校验 name初始化为null ，age初始为0 **********************************/
        assertNull(name);
        assertEquals(0, age);
        assertFalse(stack.dirty());
        assertFalse(stack.undoEnabled());
        assertFalse(stack.redoEnabled());


        /***Name cmd  **********************************/

        stack.add(new EditName("Peter"));

        assertTrue(stack.dirty());
        assertEquals("Peter", name);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());

        stack.undo();

        assertNull(name);
        assertFalse(stack.undoEnabled());
        assertTrue(stack.redoEnabled());
        assertFalse(stack.dirty());

        stack.redo();

        assertTrue(stack.dirty());
        assertEquals("Peter", name);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());

        stack.markSaveLocation();

        assertFalse(stack.dirty());
        assertEquals("Peter", name);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());

        stack.add(new EditAge(10));

        assertTrue(stack.dirty());
        assertEquals(10, age);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());

        stack.undo();

        assertFalse(stack.dirty());
        assertEquals(0, age);
        assertTrue(stack.undoEnabled());
        assertTrue(stack.redoEnabled());

        stack.add(new EditName("Pan"));

        assertTrue(stack.dirty());
        assertEquals("Pan", name);
        assertEquals(0, age);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());

        stack.undo();
        stack.undo();

        assertTrue(stack.dirty());
        assertNull(name);
        assertEquals(0, age);
        assertFalse(stack.undoEnabled());
        assertTrue(stack.redoEnabled());

        stack.redo();
        stack.redo();

        assertTrue(stack.dirty());
        assertEquals("Pan", name);
        assertEquals(0, age);
        assertTrue(stack.undoEnabled());
        assertFalse(stack.redoEnabled());
    }

}