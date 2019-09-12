package thread.thread_pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class GuavaThreadPool {
    private static ThreadFactory namedThreadFactory =
            new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            pool.execute(new Task());
        }
    }
}
