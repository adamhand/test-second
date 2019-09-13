package thread.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DiscardOldestPolicyDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());

        MyTask task = new MyTask();
        for (int i = 0; i < 10; i++) {
            pool.execute(task);
        }
        pool.shutdown();
    }
}

class MyTask implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        System.out.println("running_task: " + count.getAndIncrement());
        try {
            Thread.sleep(100) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
