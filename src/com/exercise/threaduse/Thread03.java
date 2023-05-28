package com.exercise.threaduse;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 * thread.join() makes main thread wait for thread to die
 * thread.yield()
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        for (int i = 0; i < 10 ; i++) {
            System.out.println("main says Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 4)  {
                thread.start();
                thread.join(); // main thread waits for thread to die
            }
        }

    }
}

class T implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("T says Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}