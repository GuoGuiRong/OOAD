package strategy;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class VIPDistinct implements CalculatePrice{

    /**
     * VIP半折优惠
     * @param origlePrice 电影票的原价
     * @return
     */
    @Override
    public Double calculate(Double origlePrice) {
        return origlePrice*0.5;
    }
}
