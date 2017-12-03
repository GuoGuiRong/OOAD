package observer;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class MyObserver implements Observer {

    private String state;

    @Override
    public void updateState() {
        System.out.println("State("+state+"=====>正常工作)");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public MyObserver(){
        super();
    }

    public MyObserver(String state){
        super();
        this.setState(state);
    }
}
