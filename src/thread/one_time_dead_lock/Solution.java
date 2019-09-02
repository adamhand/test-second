package thread.one_time_dead_lock;

public class Solution implements Runnable {
    private boolean flag;

    Solution (boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.lockA) {
                System.out.println(">>> if locka");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MyLock.loacB) {
                    System.out.println(">>> if lockb");
                }
            }
        } else {
            synchronized (MyLock.loacB) {
                System.out.println("<<< else loakb");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (MyLock.lockA) {
                    System.out.println("<<< else locka");
                }
            }
        }
    }
}

class MyLock {
    public static final Object lockA = new Object();
    public static final Object loacB = new Object();
}

class Main {
    public static void main(String[] args) {
        Solution solution1 = new Solution(true);
        Solution solution2 = new Solution(false);

        new Thread(solution1).start();
        new Thread(solution2).start();
    }
}