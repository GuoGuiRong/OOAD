package chain_of_responsibility;

/**
 * Created by GuiRunning on 2017/11/30.
 */
public class BossHandler extends Handler {

    @Override
    public Message handleResult(Message msg) {
        if(msg.getTotalPrice()>10000){
            msg.setNote(msg.getNote()+"Boss意见:不同意！\n");
        }else{
            msg.setNote(msg.getNote()+"Boss意见：同意！\n");
        }
        return msg;
    }
}
