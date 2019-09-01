package thread.print_numbers;

// 两个线程交替打印奇偶数
public class PrintNumberThread1 implements Runnable {
    private static int num = 0;
    private boolean flag;

    PrintNumberThread1(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (PrintNumberThread1.class) {
                if (flag) {
                    if ((num & 0x01) == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + num++);
                        if (num == 10)
                            System.exit(1);
                    }
                } else {
                    if ((num & 0x01) != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + num++);
                        if (num == 10)
                            System.exit(1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintNumberThread1(true)).start();
        new Thread(new PrintNumberThread1(false)).start();
    }
}
