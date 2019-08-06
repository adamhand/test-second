package thread.blocking_queue_test;

import java.util.concurrent.ArrayBlockingQueue;

class Cookie {

}

class Productor implements Runnable {
    private ArrayBlockingQueue abq;

    Productor(ArrayBlockingQueue abq) {
        this.abq = abq;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produce();
        }
    }

    private void produce() {
        Cookie cookie = new Cookie();
        try {
            abq.put(cookie);
            System.out.println(">>> produce " + cookie +" , count is " + abq.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private ArrayBlockingQueue abq;

    Consumer(ArrayBlockingQueue abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consume();
        }
    }

    private void consume() {
        Cookie cookie = null;
        try {
            cookie = (Cookie) abq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("<<< consume " + cookie + " , count is " + abq.size());
    }
}

public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue abq = new ArrayBlockingQueue(10);
        new Thread(new Productor(abq)).start();
        new Thread(new Consumer(abq)).start();
    }
}
