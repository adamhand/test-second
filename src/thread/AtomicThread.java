package thread;

import sun.java2d.loops.TransformHelper;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread {
    private static class MyThread implements Runnable {
        private AtomicInteger num = new AtomicInteger(100);

        @Override
        public void run() {
            while (num.get() > 0) {
                System.out.println(">>> 线程" + Thread.currentThread().getName() + "...sale..." + num.getAndDecrement());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread0 = new Thread(myThread);
        Thread thread1 = new Thread(myThread);

        thread0.start();
        thread1.start();
    }
}
