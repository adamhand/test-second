package thread;

public class YieldTest {
    private static class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                System.out.println("thread is :" + Thread.currentThread().getName() + ">>>" + i +" " +
                Thread.currentThread().getPriority());
                if (i % 10 == 0){
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        Thread t3 = new Thread(new MyThread());

        t1.setName("thread-1");
        t2.setName("thread-2");
        t3.setName("thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
