package chain_of_responsibility;

/**
 * Created by GuiRunning on 2017/11/30.
 */
public abstract  class Handler {

    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public abstract Message handleResult(Message msg);
}
