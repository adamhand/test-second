package thread.thread_pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DiscardPolicyDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), new ThreadPoolExecutor.DiscardPolicy());

        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            pool.execute(task);
        }
        pool.shutdown();
    }
}
