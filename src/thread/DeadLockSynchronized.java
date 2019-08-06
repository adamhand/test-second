package thread;

import sun.java2d.loops.TransformHelper;

public class DeadLockSynchronized {
    private static class MyThread implements Runnable {
        private boolean flag;

        public MyThread(boolean flag) {
            this.flag = flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                while (true){
                    synchronized (MyLock.locka) {
                        System.out.println(">>> " + Thread.currentThread().getName() + " if locka...");
                        synchronized (MyLock.lockb) {
                            System.out.println(">>>>>> " + Thread.currentThread().getName() + " if lockb......");
                        }
                    }
                }
            }else {
                while (true) {
                    synchronized (MyLock.lockb) {
                        System.out.println(">>>>>> " + Thread.currentThread().getName() + " if lockb......");
                        synchronized (MyLock.locka) {
                            System.out.println(">>> " + Thread.currentThread().getName() + " if locka...");
                        }
                    }
                }
            }
        }
    }
    private static class MyLock {
        public static final Object locka = new Object();
        public static final Object lockb = new Object();
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
