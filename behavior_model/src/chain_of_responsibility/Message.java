package chain_of_responsibility;

/**
 * Created by GuiRunning on 2017/11/30.
 */
public class Message {

    private double totalPrice;//总金额
    private String detail;//账单明细
    private String  note;//备注


    public Message() {
    }

    public Message(double totalPrice, String detail, String note) {

        this.totalPrice = totalPrice;
        this.detail = detail;
        this.note = note;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Message{" +
                "totalPrice=" + totalPrice +
                ", detail='" + detail + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
