package com.esuizhen.bigdata.cmd.cmd_test04;


class Test {

    public static void main(String[] args) {

        ChangeManager manager = new ChangeManager();

        manager.addChangeable(new CommandLineChanger("1"));

        manager.addChangeable(new CommandLineChanger("2"));

        manager.undo();

        manager.redo();

        manager.undo();

        manager.undo();

        manager.addChangeable(new CommandLineChanger("3"));

        manager.undo();


    }

    public static class CommandLineChanger implements Changeable {


        private final String val;

        public CommandLineChanger(String v) {

            super();

            this.val = v;

        }


        public void undo() {

            System.out.println(val + " undone");

        }


        public void redo() {

            System.out.println(val + " redone");

        }

    }

}
