package com.exercise.threaduse;

/**
 * @author Xuanchi GUO
 * @created 27.05.23
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class ThreadProxy implements Runnable {
    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public void start() {
        start0();
    }

    private native void start0();
}

class Dog implements Runnable {
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