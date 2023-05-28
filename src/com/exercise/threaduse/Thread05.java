package com.exercise.threaduse;

/**
 * @author Xuanchi GUO
 * @created 28.05.23
 * sell tickets with three threads
 * synchronized method
 */
public class Thread05 {
    public static void main(String[] args) {
        // Create three threads to sell tickets
        SellTicket sellTicket1 = new SellTicket();
        Thread thread1 = new Thread(sellTicket1);
        Thread thread2 = new Thread(sellTicket1);
        Thread thread3 = new Thread(sellTicket1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SellTicket implements Runnable{
    private int ticketNum = 100; //
    private boolean flag = true;

    Object object = new Object(); //

    //
    private static void sellTicket1() {
        synchronized (SellTicket.class) {
            System.out.println(Thread.currentThread().getName() + " sold ticket, left tickets ");
        }
    }


    private void sellTicket() {
        synchronized (this) { // must be the same object(whatever object is) for all threads
            if (ticketNum <= 0) {
                System.out.println("Ticket sold out!");
                flag = false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sold ticket, left tickets " + --ticketNum);
        }
    }

    @Override
    public void run() {
        while (flag) {
            sellTicket();
        }
    }
}