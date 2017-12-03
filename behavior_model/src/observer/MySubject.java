package observer;

import java.util.Vector;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public abstract class MySubject implements Subject {

    private boolean changed = false;
    private Vector<Observer> vector = new Vector<Observer>();


    public boolean hasChanged() {
        return changed;
    }

    public void setChanged() {
        changed = true;
    }

    public void cancleChanged() {
        changed = false;
    }

    @Override
    public void addObserver(Observer observer) {
        synchronized (this){
            vector.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        synchronized (this) {
            vector.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        synchronized (this) {
            if(!this.hasChanged())return;
            if(this.vector.isEmpty())return;
            for (Observer observer : vector) {
                observer.updateState();
            }
            this.cancleChanged();
        }
    }
}
