package sample;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

public class ClickAfterTime implements Runnable{

    private final Integer time;
    private final boolean shootdown;

    public ClickAfterTime(Integer timeOut, boolean selected) {

        this.time = timeOut;
        this.shootdown = selected;
        System.out.println(timeOut);
        System.out.println(selected);
    }

    public void run() {

        try {
            // Задержка
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //System.out.println(time);

        if(shootdown) {
            try {
                ShootDown.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("shootdown");
        }

    }

}
