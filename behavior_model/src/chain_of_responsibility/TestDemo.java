package chain_of_responsibility;

import org.junit.Test;

/**
 * Created by GuiRunning on 2017/11/30.
 */
public class TestDemo {

    @Test
    public void testdemo1(){
        Handler manager = new ManagerHandler();
        Handler boss = new BossHandler();
        manager.setSuccessor(boss);

        System.out.println("王老五提交了一个金额为500元的报销单!");
        Message result = manager.handleResult(new Message(500,"加班打车：共计500元",""));

        System.out.println(result.toString());

        System.out.println("王老五提交了一个金额为1000元的报销单!");
        Message result2 = manager.handleResult(new Message(1000,"加班打车：共计1000元",""));

        System.out.println(result2.toString());
    }
}
