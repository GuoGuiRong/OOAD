package strategy;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class StudentDistinct implements CalculatePrice {
    @Override
    public Double calculate(Double origlePrice) {
        return origlePrice*0.8;
    }
}
