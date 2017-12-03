package strategy.more;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class HarrierFeature implements  Feature {
    @Override
    public void doFeature() {
        System.out.print("飞机种类:鹞式战斗机(Harrier)");
        System.out.print("起飞特征:垂直起飞(VerticalTakeOff)");
        System.out.println("飞行特征 超音速飞行(SuperSonicFly)");
    }
}
