package thread.print_numbers;

public class PrintNumbersThread0 implements Runnable{
    private static volatile int count = 0;
    private int[] nums;
    private boolean flag;

    PrintNumbersThread0(int[] nums, boolean flag) {
        this.nums = nums;
        this.flag = flag;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {
        while (true) {
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 5};
        new Thread(new PrintNumbersThread0(nums, true)).start();
        new Thread(new PrintNumbersThread0(nums, false)).start();
    }
}
