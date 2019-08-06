package thread;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockReentrantlock {
    private static class MyThread implements Runnable {
        private boolean flag;
        ReentrantLock locka = new ReentrantLock();
        ReentrantLock lockb = new ReentrantLock();

        MyThread(boolean flag) {
            this.flag = flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                while (true) {
                    try {
                        locka.lock();
                        System.out.println(">>> " + Thread.currentThread().getName() + " if locka...");

                        try {
                            lockb.lock();
                            System.out.println(">>>>> " + Thread.currentThread().getName() + " if lockb ......");
                        } finally {
                            lockb.unlock();
                        }
                    } finally {
                        locka.unlock();
                    }
                }
            } else {
                try {
                    lockb.lock();
                    System.out.println(">>>>>> " + Thread.currentThread().getName() + " if lockb ......");

                    try {
                        locka.lock();
                        System.out.println(">>> " + Thread.currentThread().getName() + " if locka ...");
                    } finally {
                        locka.unlock();
                    }
                } finally {
                    lockb.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(true);

        Thread thread0 = new Thread(myThread);
        Thread thread1 = new Thread(myThread);

        thread0.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.setFlag(false);
        thread1.start();
    }
}
