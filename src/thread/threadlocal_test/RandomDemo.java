package thread.threadlocal_test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RandomDemo {
    private static class ProduceRandom implements Runnable {
        private Random random;
        private CountDownLatch latch;

        ProduceRandom(Random random, CountDownLatch latch) {
            this.random = random;
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();
            System.out.println(">>> " + Thread.currentThread().getName() +
                    " " + random.nextInt(5));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Random random = new Random();
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new ProduceRandom(random, latch)).start();
        new Thread(new ProduceRandom(random, latch)).start();

        latch.await();
    }
}
