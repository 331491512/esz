package com.esuizhen.bigdata.cmd.cmd_;

import java.util.Iterator;
import java.util.List;

public class TestCommand {
    public static void main(String[] args) {
        List queue = Producer.produceRequests();
        for (Iterator it = queue.iterator(); it.hasNext(); ) {
            //客户端直接调用execute方法，无需知道被调用者的其它更多类的方法名。
            //((Command) it.next()).execute();
            ((Command) it.next()).executeMerge();
            ((Command) it.next()).undo();
        }
    }
}