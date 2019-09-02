package thread.print_numbers;

import java.util.concurrent.atomic.AtomicInteger;

//两个线程交替打印奇偶数，无锁。
public class PrintNumberThread2 implements Runnable{
    private static AtomicInteger num = new AtomicInteger();
    private static boolean flag = false;

    @Override
    public void run() {
        while (num.intValue() < 10) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + " " + num.getAndIncrement());
                flag = false;
            } else {
                System.out.println(Thread.currentThread().getName() + " " + num.getAndIncrement());
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintNumberThread2()).start();
        new Thread(new PrintNumberThread2()).start();
    }
}
