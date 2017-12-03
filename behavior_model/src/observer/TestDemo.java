package observer;

import org.junit.Test;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class TestDemo {
    @Test
    public void testDemoirst(){
        MySubject subject = new MySubjectImpl("老板最新动态");
        Observer zhangsan = new MyObserver("玩游戏");
        Observer lisi = new MyObserver("看股票");

        subject.addObserver(zhangsan);
        subject.addObserver(lisi);
        subject.setChanged();
        subject.notifyAllObserver();


    }
}
