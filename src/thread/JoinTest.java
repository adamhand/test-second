package thread;

public class JoinTest {
    private static class Thread0 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(">>> 线程0在执行任务" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    Thread thread = new Thread(new Thread1());
                    thread.start();
                    try {
                        // thread.join();
                        thread.join(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(">>>>>>> 线程1在执行任务" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread0());
        thread.start();
    }
}
