package thread.print_numbers;

public class PrintNumberThread3 {
    private volatile static boolean open = false;
    private volatile static int index = 0;

    public static void main(String[] args) {
        new Thread(new myRun1(), "线程1").start();
        new Thread(new myRun2(), "线程2").start();
    }

    static class myRun1 implements Runnable {
        @Override
        public void run() {
            while (index < 10) {
                if (open) {
                    System.out.println(Thread.currentThread().getName() + ": " + index++);
                    open = false;
                }
            }
        }
    }

    static class myRun2 implements Runnable {
        @Override
        public void run() {
            while (index < 10) {
                if (!open) {
                    System.out.println(Thread.currentThread().getName() + ": " + index++);
                    open = true;
                }
            }
        }
    }
}
