package com.exercise.threaduse;

/**
 * @author Xuanchi GUO
 * @created 27.05.23
 */
public class Thread01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // start0() is a native method
        myThread.start();
        // main thread and myThread are running concurrently
        // death of main thread doesn't mean death of myThread or death of the program
        // myThread will continue to run until it finishes its job
        for (int i = 0; i < 10; i++) {
            System.out.println("main" + i + "thread id: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    int counter = 0;
    @Override
    public void run() {
        do {
            System.out.println("MyThread" + counter++ + "thread id: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (counter != 10);
    }
}

