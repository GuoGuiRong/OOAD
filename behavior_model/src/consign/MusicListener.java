package consign;

import java.util.Date;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class MusicListener{

    public MusicListener() {
        listenMusic();
    }

    public void listenMusic(){
        System.out.println(new Date()+" I'm listenning music");
    }

    public void stopMusic(){
        System.out.println(new Date()+" I'm stop for it");
    }
}
