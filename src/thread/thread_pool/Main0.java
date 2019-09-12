package thread.thread_pool;

import java.util.concurrent.*;

class MyThread implements Runnable {
    private static volatile int num = 0;

    @Override
    public void run() {
        while (num < 100) {
            synchronized (MyThread.class) {
                num++;
                System.out.printf("%d ", num);
            }
        }
    }
}

public class Main0 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newScheduledThreadPool(3);
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        ScheduledThreadPoolExecutor pool4 = new ScheduledThreadPoolExecutor(5);
        pool.execute(new MyThread());
        pool.shutdown();
    }
}
