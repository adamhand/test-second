package thread.blocking_queue_test;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueDemo {
    private static LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

    private class Productor implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Producer is waiting to transfer...");
                    System.out.println("producer transfered element: A "+i);
                    queue.transfer("A " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Consumer is waiting to take element...");
                    String s= queue.take();
                    System.out.println("Consumer received Element: "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new LinkedTransferQueueDemo().new Productor()).start();
        new Thread(new LinkedTransferQueueDemo().new Consumer()).start();
    }
}
