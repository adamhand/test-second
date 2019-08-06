package thread.thread_unsafe_example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyExample {
    private int cnt = 0;

    public void addCnt() {
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }
}

public class ThreadUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        final int threadCount = 10000;
        MyExample example = new MyExample();
        final CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    example.addCnt();
                    latch.countDown();
                }
            });
        }
        latch.await();
        service.shutdown();
        System.out.println(">>> cnt is " + example.getCnt());
    }
}
