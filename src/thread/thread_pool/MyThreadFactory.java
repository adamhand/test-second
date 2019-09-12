package thread.thread_pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MyThreadFactory implements ThreadFactory{
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    MyThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "MyThreadFactory's " + whatFeatureOfGroup + " -Worder-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        // 参数分别为：ThreadGroup, Runnable, name, stackSize
        Thread thread = new Thread(null, r, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}

class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        System.out.println("running_task: " + count.getAndIncrement());
    }
}
