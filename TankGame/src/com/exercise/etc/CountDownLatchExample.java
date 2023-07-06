package proto.grpc.etc;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        // Create worker threads
        for (int i = 0; i < numberOfTasks; i++) {
            WorkerThread worker = new WorkerThread(latch);
            Thread thread = new Thread(worker);
            thread.start();
        }

        // Main thread waits for all tasks to complete
        latch.await();
        System.out.println("All tasks completed. Proceeding with the main thread.");
    }

    static class WorkerThread implements Runnable {
        private CountDownLatch latch;

        public WorkerThread(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            // Simulating some task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task completed.");
            latch.countDown(); // Decrease the count
        }
    }
}

//public class WaitNotifyExample {
//    public static void main(String[] args) {
//        Object lock = new Object();
//
//        Thread waitingThread = new Thread(() -> {
//            synchronized (lock) {
//                try {
//                    System.out.println("Waiting thread is waiting...");
//                    lock.wait(); // Releases the lock and waits
//                    System.out.println("Waiting thread is notified and resumed");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread notifyingThread = new Thread(() -> {
//            synchronized (lock) {
//                System.out.println("Notifying thread is performing some work");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock.notify(); // Notifies the waiting thread
//                // lock.notifyAll(); // Notifies all waiting threads
//                System.out.println("Notifying thread has notified");
//            }
//        });
//
//        waitingThread.start();
//        notifyingThread.start();
//    }
//}

//package proto.grpc.join;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author Xuanchi Guo
// * @project sem-stream-fusion
// * @created 6/24/23
// */
////public class VolatileTest {
////    private static final int THREADS_COUNT = 20;
////    public static AtomicInteger race = new AtomicInteger(0);
////
////    public static void increase() {
////        race.incrementAndGet();
////    }
////
////    public static void main(String[] args) {
////        Thread[] threads = new Thread[THREADS_COUNT];
////        for (int i = 0; i < THREADS_COUNT; i++) {
////            threads[i] = new Thread(() -> {
////                for (int i1 = 0; i1 < 10000; i1++) {
////                    increase();
////                }
////            });
////            threads[i].start();
////        }
////        while (Thread.activeCount() > 2)
////            Thread.yield();
////        System.out.println(race);
////    }
////}
////public class ReorderExample {
////    private int a = 2;
////    private boolean flg = false;
////
////    public void method1() {
////        a = 1;
////        flg = true;
////    }
////
////    public void method2() {
////        if (flg) {
////            //2 might be printed out on some JVM/machines
////            System.out.println("a = " + a);
////        }
////    }
////
////    public static void main(String[] args) {
////        for (int i = 0; i < 100; i++) {
////            ReorderExample reorderExample = new ReorderExample();
////            Thread thread1 = new Thread(() -> {
////                reorderExample.method1();
////            });
////            Thread thread2 = new Thread(() -> {
////                reorderExample.method2();
////            });
////            thread1.start();
////            thread2.start();
////        }
////    }
////}
//
//
////public class AtomicTest {
////    public String concatString(String s1, String s2, String s3) {
////        StringBuffer sb = new StringBuffer();
////        sb.append(s1);
////        sb.append(s2);
////        sb.append(s3);
////        return sb.toString();
////    }
////
////    public static void main(String[] args) {
////        String element = "<http://www.w3.org/ns/sos/Result>";
////        int res1 = MurmurHash3.hash32x86(element.getBytes(StandardCharsets.UTF_8));
////        int res2 = MurmurHash3.hash32x86(element.getBytes(StandardCharsets.UTF_8));
////        int res3 = MurmurHash3.hash32x86(element.getBytes(StandardCharsets.UTF_8));
////        int res4 = MurmurHash3.hash32x86(element.getBytes(StandardCharsets.UTF_8));
////        System.out.println(res1);
////        System.out.println(res2);
////        System.out.println(res3);
////        System.out.println(res4);
////    }
////}
//public class LockExample {
//
//    private Lock lock = new ReentrantLock();
//
//    public void func() {
//        lock.lock();
//        try {
//            for (int i = 0; i < 10; i++) {
//                System.out.print(i + " ");
//            }
//        } finally {
//            lock.unlock(); // 确保释放锁，从而避免发生死锁。
//        }
//    }
//
//    public static void main(String[] args) {
//        LockExample lockExample = new LockExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(lockExample::func);
//        executorService.execute(lockExample::func);
//    }
//}
