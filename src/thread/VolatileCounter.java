package thread;

import java.util.concurrent.CountDownLatch;

public class VolatileCounter {
    private static volatile int num = 0;
    private static CountDownLatch latch = new CountDownLatch(30);

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        num++;
                    }
                    latch.countDown();
                }
            }.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
