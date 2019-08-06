package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSolve {

    private static class MyThread implements Runnable {
        private boolean flag;
        private Lock locka = new ReentrantLock();
        private Lock lockb = new ReentrantLock();

        MyThread(boolean flag) {
            this.flag = flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                while (true){
                    try {
                        locka.lock();
                        System.out.println(">>> " + Thread.currentThread().getName() + " if locka ...");

                        try {
                            if (lockb.tryLock(100, TimeUnit.MILLISECONDS)){
                                System.out.println(">>>>>> " + Thread.currentThread().getName() + " if lockb ......");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lockb.unlock();
                        }
                    } finally {
                        locka.unlock();
                    }
                }
            } else {
                while (true) {
                    try {
                        lockb.lock();
                        System.out.println(">>>>>> " + Thread.currentThread().getName() + " if lockb ......");

                        if (locka.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println(">>> " + Thread.currentThread().getName() + " if locka ...");
                            } finally {
                                locka.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lockb.unlock();
                    }
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
