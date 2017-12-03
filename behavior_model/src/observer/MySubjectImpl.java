package observer;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class MySubjectImpl extends  MySubject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public MySubjectImpl(){
        super();
    }

    public MySubjectImpl(String name){
        super();
        this.name = name;
    }
}
