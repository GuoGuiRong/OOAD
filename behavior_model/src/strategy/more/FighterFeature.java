package strategy.more;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class FighterFeature implements  Feature {
    @Override
    public void doFeature() {
        System.out.print("飞机类型：歼击机(Fighter)");
        System.out.print("起飞特征：长距离起飞(LongDistanceTakeOff)");
        System.out.println("飞行特征：超音速飞行(SuperSonicFly)");
    }
}
