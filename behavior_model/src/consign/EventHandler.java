package consign;

import java.util.Vector;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class EventHandler {

    private Vector<Event> events;

    public EventHandler(){
        this.events = new Vector<>();
    }

    public synchronized void addEvent(Object object, String methodName, Object[] params){
        this.events.add(new Event(object,methodName,params));
    }

    public synchronized void removeEvent(Object object, String methodName, Object[] params){
        this.events.remove(new Event(object,methodName,params));
    }

    public synchronized void notifyEvents() throws Exception {
        for (Event event:events){
            event.invoke();
        }
    }
}
