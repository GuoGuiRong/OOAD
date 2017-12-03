package consign;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class GoodNotifier extends Notifier {
    @Override
    public void addListener(Object object, String methodName, Object[] params) {
        this.getEventHandler().addEvent(object,methodName,params);
    }

    @Override
    public void notifyEvents() throws Exception {
        this.getEventHandler().notifyEvents();
    }
}
