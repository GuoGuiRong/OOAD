package vistor;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public abstract class Action {
    public String action;
    public abstract  void doAction();

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
