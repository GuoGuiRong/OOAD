package consign;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public abstract  class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public abstract void addListener(Object object, String methodName, Object[] params);
    public abstract void notifyEvents() throws Exception;
}
