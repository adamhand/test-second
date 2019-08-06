package thread;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread is :" + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Thread thread = new ExtendsThread();
        thread.start();
        thread.run();
    }
}
