package thread.threadlocal_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {
    private static class ProduceRandom implements Runnable {
        private CountDownLatch latch;

        ProduceRandom(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();
            System.out.println(">>> " + Thread.currentThread().getName() +
                    " " + ThreadLocalRandom.current().nextInt(5));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new ProduceRandom(latch)).start();
        new Thread(new ProduceRandom(latch)).start();

        latch.await();
    }
}
