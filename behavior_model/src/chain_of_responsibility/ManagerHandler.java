package chain_of_responsibility;

/**
 * Created by GuiRunning on 2017/11/30.
 */
public class ManagerHandler extends Handler {

    public Message handleResult(Message msg) {
        if(msg.getTotalPrice()>500){
            msg.setNote(msg.getNote()+"金额过大，需要提交上级审批！\n");
            this.getSuccessor().handleResult(msg);
        }else{
            msg.setNote("部门经理意见:同意！\n");
        }
        return msg;
    }
}
