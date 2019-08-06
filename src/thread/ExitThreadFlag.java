package thread;

import java.util.TreeMap;

public class ExitThreadFlag {
    class MyThread implements Runnable {
        public volatile boolean flag = false;

        @Override
        public void run() {
            while (!flag) {
                System.out.println(">>> 线程 MyThread 在执行");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(">>>>>> 线程 MyThread 马上要执行完毕");
        }
    }
}

class Main {
    public static void main(String[] args) {
//        ExitThreadFlag exitThreadFlag = new ExitThreadFlag();
//        ExitThreadFlag.MyThread thread = exitThreadFlag.new MyThread();

//        ExitThreadFlag.MyThread thread = new ExitThreadFlag().new MyThread();
//        Thread thread = new Thread(new ExitThreadFlag().new MyThread());


        ExitThreadFlag.MyThread t = new ExitThreadFlag().new MyThread();
        Thread thread = new Thread(t);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = true;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
