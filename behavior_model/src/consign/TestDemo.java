package consign;

import org.junit.Test;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class TestDemo{
    @Test
    public void testDemo(){
        GoodNotifier notifier = new GoodNotifier();
        MusicListener musicListener = new MusicListener();
        notifier.addListener(musicListener,"stopMusic",new Object[]{});
        try {
            notifier.notifyEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
