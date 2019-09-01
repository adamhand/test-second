package algorithm;

import java.util.Arrays;

public class QuickSort {
    private int partition(int[] nums, int left, int right) {
        int pivotKey = nums[right];
        while (left < right) {
            while (left < right && nums[left] <= pivotKey)
                left++;
            nums[right] = nums[left];

            while (left < right && nums[right] >= pivotKey)
                right--;
            nums[left] = nums[right];
        }
        nums[right] = pivotKey;

        return left;
    }

    private void qSort(int[] nums, int left, int right) {
        if (left < right) {
            int position = partition(nums, 0, right);
            qSort(nums, left, position - 1);
            qSort(nums, position, right);
        }
    }

    public void qSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {9,6,7,8,0,6,5,3,4,1,2,3,5};
        new QuickSort().qSort(nums);

        Arrays.stream(nums).forEach(a->{
            System.out.print(a + " ");
        });
    }
}
