package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableThread implements Callable {
    private String taskNum;

    public CallableThread(String taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public Object call() {
        System.out.println(">>>" + taskNum + "任务启动");
        Date startTime = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date endTime = new Date();

        long timeDiv = endTime.getTime() - startTime.getTime();
        System.out.println(">>>任务" + taskNum + "结束");

        return taskNum + "运行时间为" + timeDiv;
    }

    public static void main(String[] args) {
        int taskNum = 5;

        List<Future> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(taskNum);
        for (int i = 0; i < 5; i++){
            Callable c = new CallableThread(String.valueOf(i));
            Future f = pool.submit(c);
            results.add(f);
        }
        pool.shutdown();

        for (Future f : results){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
