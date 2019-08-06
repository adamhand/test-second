package thread;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingSynchronizedThread {
    private LinkedBlockingQueue queue  = new LinkedBlockingQueue();

    private static final int size = 10;

    private int flag = 0;  // flag == true表示还有商品

    private class LinkedBlockThread implements Runnable {
        @Override
        public void run() {
            int new_flag = flag++;
            System.out.println(">>>>>>>>>>启动线程" + new_flag);
            if (new_flag == 0) {
                for (int i = 0; i < size; i++) {
                    System.out.println(">>> 生产商品 " + i);
                    try {
                        queue.put(i);
                        System.out.println("仓库中还有商品 " + queue.size() + "个");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                for (int i = 0; i < size / 2; i++) {
                    try {
                        int n = (int)queue.take();
                        System.out.println(">>>>>商品 " + n + "被消费" + " 仓库中还有 " + queue.size() + "个商品");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingSynchronizedThread.LinkedBlockThread t= new BlockingSynchronizedThread().new LinkedBlockThread();
        Thread thread0 = new Thread(t);
        Thread thread1 = new Thread(t);

        thread0.start();
        thread1.start();
    }
}
