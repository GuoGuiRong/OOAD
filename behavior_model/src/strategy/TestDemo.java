package strategy;

import org.junit.Test;
import strategy.more.Feature;
import strategy.more.Plane;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class TestDemo {

    @Test
    public void testDmeo(){
        MoviceTicle ticle = new MoviceTicle(30.00);
        System.out.println("学生价："+ticle.getRealPrice(new StudentDistinct()));
        System.out.println("VIP价："+ticle.getRealPrice(new VIPDistinct()));
        System.out.println("儿童价："+ticle.getRealPrice(new ChildrenDistinct()));
    }

    @Test
    public void testDemo1(){
        MoviceTicle ticle = new MoviceTicle(30.00);
        try {
            CalculatePrice calculatePrice = (CalculatePrice)XMLUtil.getBean("strategy/config.xml");
            System.out.println("学生价："+ticle.getRealPrice(calculatePrice));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDemo2(){
        Feature feature = (Feature)XMLUtil.getBean("strategy/more/feature.xml");
        Plane plane = new Plane();
        plane.setFeature(feature);
        plane.getFeature().doFeature();
    }

}
