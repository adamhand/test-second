package thread.blocking_queue_test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

class Toy {
    private int num;

    Toy(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "toy number is " + num;
    }
}

class ToyProductor implements Runnable{
    private BlockingQueue<Toy> queue;
    private Random random = new Random();

    ToyProductor(BlockingQueue<Toy> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Toy toy = new Toy(random.nextInt(1000));
            try {
                System.out.println(">>> productor : " + toy.toString());
                queue.put(toy);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ToyConsumer implements Runnable {
    private BlockingQueue<Toy> queue;

    ToyConsumer(BlockingQueue<Toy> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true)    {
            try {
                Toy toy = queue.take();
                System.out.println("<<<<<< consumer : " + toy.toString());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizedBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Toy> queue = new SynchronousQueue<>();

        ToyProductor productor = new ToyProductor(queue);
        ToyConsumer consumer = new ToyConsumer(queue);

        new Thread(productor).start();
        new Thread(consumer).start();
    }
}
