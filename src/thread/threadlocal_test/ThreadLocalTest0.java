package thread.threadlocal_test;

public class ThreadLocalTest0 {
    private ThreadLocal<Integer > localCount = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextCount(){
        localCount.set(localCount.get() + 1);

        return localCount.get();
    }

    public void removeCount() {
        localCount.remove();
    }

    private static class LocalCountThread implements Runnable {
        private ThreadLocalTest0 test0 = new ThreadLocalTest0();

        LocalCountThread(ThreadLocalTest0 test0) {
            this.test0 = test0;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(">>> local count is " + Thread.currentThread().getName() + " " + test0.getNextCount());
            }
            test0.removeCount();
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest0 test0 = new ThreadLocalTest0();

        new Thread(new LocalCountThread(test0)).start();
        new Thread(new LocalCountThread(test0)).start();
        new Thread(new LocalCountThread(test0)).start();
        new Thread(new LocalCountThread(test0)).start();
    }
}
