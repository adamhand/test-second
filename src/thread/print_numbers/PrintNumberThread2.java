package thread.print_numbers;

import java.util.concurrent.atomic.AtomicInteger;

//两个线程交替打印奇偶数，无锁，还有问题
public class PrintNumberThread2 implements Runnable{
    private static AtomicInteger num = new AtomicInteger();
    private boolean flag;

    PrintNumberThread2(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            if (flag) {
                if ((num.intValue() & 0x01) == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + num.getAndIncrement());
                }

                if (num.intValue() == 10)
                    System.exit(1);
            } else {
                if ((num.intValue() & 0x01) == 1) {
                    System.out.println(Thread.currentThread().getName() + " " + num.getAndIncrement());
                }

                if (num.intValue() == 10)
                    System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintNumberThread2(true)).start();
        new Thread(new PrintNumberThread2(true)).start();
    }
}
