package com.exercise.homework;

import java.util.Scanner;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 * Create two threads, one thread prints random numbers, the other thread reads the keyboard input, if the input is 'Q', then the first thread stops.
 */
public class Homework01 {
    public static void main(String[] args) {

        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((int) (Math.random() * 100) + 1);
        }
    }
}

class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("Please enter a number: ");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q') { // quit
                a.setFlag(false); // stop thread A
                System.out.println("Thread b stopped.");
                break; // stop thread B
            }
        }
    }
}