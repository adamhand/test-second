package thread.print_numbers;

import thread.ExitThread;

public class PrintNumberThread implements Runnable{
    private static int count = 0;
    private boolean flag;
    private int[] nums;

    PrintNumberThread(int[] nums, boolean flag) {
        this.nums = nums;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (PrintNumberThread.class) {
                if (flag) {
                    if ((nums[count] & 0x01) == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + nums[count]);
                        count++;
                    }
                } else {
                    if ((nums[count] & 0x01) != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + nums[count]);
                        count++;
                    }
                }

                if (count == nums.length)
                    System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 5};

        new Thread(new PrintNumberThread(nums, true)).start();
        new Thread(new PrintNumberThread(nums, false)).start();
    }
}
