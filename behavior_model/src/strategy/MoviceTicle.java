package strategy;

/** 这里我们忽略电影票的其他细节，只关注价格计算这个方面，有需要可自行添加
 * Created by GuiRunning on 2017/12/3.
 */
public class MoviceTicle {

    private Double origlePrice;
    private CalculatePrice calculatePrice;

    public double getRealPrice(CalculatePrice calculatePrice){
       return calculatePrice.calculate(origlePrice);
    }

    public double getRealPrice(){
        return this.calculatePrice.calculate(origlePrice);
    }

    public Double getOriglePrice() {
        return origlePrice;
    }

    public void setOriglePrice(Double origlePrice) {
        this.origlePrice = origlePrice;
    }

    public MoviceTicle(Double origlePrice) {
        this.origlePrice = origlePrice;
    }
}
