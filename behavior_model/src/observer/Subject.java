package observer;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public interface Subject {

    void addObserver(Observer observer);//订阅
    void deleteObserver(Observer observer);//取消订阅
    void notifyAllObserver();//通知所有订阅者
}
