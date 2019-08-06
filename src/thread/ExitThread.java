package thread;

public class ExitThread {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println(">>> 线程MyThread在执行");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    break;   // 退出
                }
            }
            System.out.println(">>>>线程 MyThread 马上要结束了");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
