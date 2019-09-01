package thread;

//public class ExitThreadInterrupt {
//    private static class MyThread implements Runnable {
//        @Override
//        public void run() {
//            while (true) {
//                System.out.println(">>> MyThread 在执行");
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    break;    //退出
//                }
//            }
//            System.out.println(">>>>>> 线程 MyThread 马上要执行完毕");
//        }
//    }
//
//    public static void main(String[] args) {
//        Thread thread = new Thread(new MyThread());
//        thread.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread.interrupt();
//    }
//}
//

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * interrupt方法结束线程
 */
class MyThread extends Thread
{
    @Override
    public void run() {
        while (true)
        {
            System.out.println("子线程还没退出");
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class InterruptExitThread {
    public static void main(String[] args) {
        MyThread myThread0 = new MyThread();

        myThread0.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread0.interrupt();

        System.out.println("主线程退出");
    }
}
