package strategy.more;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class HelicopterFeature implements Feature {
    @Override
    public void doFeature() {
        System.out.println("飞机类型：直升机(Helicopter)");
        System.out.println("起飞类型：垂直起飞(VerticalTakeOff)");
        System.out.println("飞行类型：亚音速飞行(SubSonicFly)");
    }
}
