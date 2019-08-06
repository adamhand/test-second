package thread;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("thread is :" + Thread.currentThread().getName() + " " +Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        RunnableThread rThreaad = new RunnableThread();
        Thread thread = new Thread(rThreaad);
        thread.start();
    }
}
