package com.exercise.threaduse;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 * daemon thread
 */
public class Thread04 {
    public static void main(String[] args) {
        MyDaemon myDaemon = new MyDaemon();
        myDaemon.setDaemon(true);
        myDaemon.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main says Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDaemon extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("I am alive");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
