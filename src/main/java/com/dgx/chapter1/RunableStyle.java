package com.dgx.chapter1;

/**
 * Create by dgx 2022-08-14 9:36
 */
public class RunableStyle implements  Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {

        System.out.println("Runable 实现");
    }

    public static void main(String[] args) {
        new Thread(new RunableStyle()).start();
    }
}
