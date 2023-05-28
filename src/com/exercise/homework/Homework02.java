package com.exercise.homework;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 */
public class Homework02 {
    public static void main(String[] args) {
        WithdrawMoney withdrawMoney = new WithdrawMoney();
        Thread thread1 = new Thread(withdrawMoney);
        thread1.setName("A");
        Thread thread2 = new Thread(withdrawMoney);
        thread2.setName("B");
        thread1.start();
        thread2.start();

    }
}

class WithdrawMoney implements Runnable {
    private int total = 10000;
    private int money = 1000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total < money) {
                    System.out.println("Money is not enough!");
                    break;
                }

                total -= money;
                System.out.println(Thread.currentThread().getId() + " withdraws " + money + " yuan, left " + total + " yuan.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}