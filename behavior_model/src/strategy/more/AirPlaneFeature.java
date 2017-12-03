package strategy.more;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class AirPlaneFeature implements Feature{

    @Override
    public void doFeature() {
        System.out.print("飞机类型：客机(AirPlane)");
        System.out.print("起飞类型：长距离起飞(LongDistanceTakeOff)");
        System.out.println("飞行类型：亚音速飞行(SubSonicFly)");
    }
}
