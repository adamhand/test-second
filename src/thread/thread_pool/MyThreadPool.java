package thread.thread_pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);

        MyThreadFactory f1 = new MyThreadFactory(" 第1机房 ");
        MyThreadFactory f2 = new MyThreadFactory(" 第2机房 ");

        MyRejectHandler handler = new MyRejectHandler();

        ThreadPoolExecutor poolFirst = new ThreadPoolExecutor(1, 2,
                60, TimeUnit.SECONDS, queue, f1, handler);
        ThreadPoolExecutor poolSecond = new ThreadPoolExecutor(1, 2,
                60, TimeUnit.SECONDS, queue, f2, handler);


        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            poolFirst.execute(task);
            poolSecond.execute(task);
        }
    }
}
