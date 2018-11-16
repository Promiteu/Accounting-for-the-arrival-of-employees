package ru.AccessTime.GUI;

import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTimeNow {
    private Thread thread;
    boolean startThread = true;

    public void startShowTime(Text text) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (startThread) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd.mm");
                    String string = simpleDateFormat.format(date).toString();
                    text.setText(string);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }
    public void stopShowTime () {
        startThread = false;
        thread.stop();

    }


}
