package offer_test.inverse_pairs;

public class Solution {
    public int InversePairs(int [] array) {
        if (array == null) {
            return -1;
        } else {
            return mergeSort(array, 0, array.length - 1) % 1000000007;
        }
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int length = right - left + 1;
        int count = 0;
        int copyIndex = right;
        int[] copy = new int[length];
        int i = mid, j = right;

        while (i >= left && j >= mid + 1) {
            if (nums[i] > nums[j]) {
                count = count + j - mid;
                copy[copyIndex--] = nums[i--];
            } else {
                copy[copyIndex--] = nums[j--];
            }
        }
        while (i >= left)
            copy[copyIndex--] = nums[i--];
        while (j >= mid + 1)
            copy[copyIndex--] = nums[j--];
        for (int k = 0; k < length; k++)
            nums[left++] = copy[k];

        return count;
    }

    private int mergeSort(int[] array, int left, int right) {
        if (left == right)
            return 0;
        int count = 0;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        count += merge(array, left, mid, right);

        return count;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(new Solution().InversePairs(array));
    }
}
