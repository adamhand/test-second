package thread.thread_interrupt;

class MyThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            
        }
    }
}

public class ThreadInterrupt {
}
