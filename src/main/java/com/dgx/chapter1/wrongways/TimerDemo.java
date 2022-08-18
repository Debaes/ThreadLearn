package com.dgx.chapter1.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by dgx 2022-08-14 11:30
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);

    }
}
