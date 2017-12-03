package strategy;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public interface CalculatePrice {

    /**
     *
     * @param origlePrice 电影票的原价
     * @return 活动期间（打折/优惠/特价等）的价格
     */
    public Double calculate(Double origlePrice);
}
