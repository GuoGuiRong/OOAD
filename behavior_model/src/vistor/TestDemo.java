package vistor;

import org.junit.Test;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class TestDemo {

    @Test
    public void testDemo(){
        Person woman = new Person();
        Person man = new Person();

        Action action = new Action() {
            @Override
            public void doAction() {
                System.out.println(getAction()+"==>12");
            }
        };
        action.setAction("get 60 ");
//        woman.addAction(action);


        Action action2 = new Action() {
            @Override
            public void doAction() {
                System.out.println(getAction()+"==>34");
            }
        };
        action2.setAction("get 60 ");
//        man.addAction(action2);

//        woman.doAction();
//        man.doAction();
        man.visit(action);
        woman.visit(action2);
    }
}
