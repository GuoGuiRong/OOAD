package strategy;

/**
 * Created by GuiRunning on 2017/12/3.
 */
public class ChildrenDistinct implements  CalculatePrice {
    @Override
    public Double calculate(Double origlePrice) {
        if(origlePrice>=20){
            return origlePrice-10;
        }
        return origlePrice;
    }
}
