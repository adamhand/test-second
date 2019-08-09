package thread.one_time_deadlock;

import java.util.concurrent.CountDownLatch;

public class DeadLockDemo {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA(latch)).start();
        new Thread(new ThreadB(latch)).start();

        latch.await();
    }
}

class ThreadA implements Runnable {
    private CountDownLatch latch;

    ThreadA(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (DeadLockDemo.lockA) {
            System.out.println(">>> if lockA...");
            latch.countDown();
            synchronized (DeadLockDemo.lockB) {
                System.out.println(">>> if lockB...");
            }
        }
    }
}

class ThreadB implements Runnable {
    private CountDownLatch latch;

    ThreadB(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (DeadLockDemo.lockB) {
            System.out.println("<<< if lockB.........");
            latch.countDown();
            synchronized (DeadLockDemo.lockA) {
                System.out.println("<<< if lockA.........");
            }
        }
    }
}
