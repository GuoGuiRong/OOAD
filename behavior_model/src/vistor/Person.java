package vistor;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class Person implements Man {

   /* private Vector<Action> actions;

    public Person(){
        actions = new Vector<>();
    }*/

   @Override
    public void visit(Action action) {
        action.doAction();
    }
/*
    public synchronized void addAction(Action action){
        this.actions.add(action);
    }

    public synchronized  void removeAction(Action action){
        this.actions.remove(action);
    }

    public void doAction() {
        for (Action action:actions) {
            action.doAction();
        }
    }*/
}
