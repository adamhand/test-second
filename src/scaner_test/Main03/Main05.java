package scaner_test.Main03;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];

        nums[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            nums[i] = sc.nextInt();
        }

        int len = n >> 1;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            while (nums[i] > 0 || nums[i * 2] > 0 || nums[i * 2 + 1] > 0) {
                if (i == len) {
                    for (int j = 2 * len; j < n; j++) {
                        while (nums[j] > 0 || nums[j + 1] > 0) {
                            nums[j]--;
                            nums[j + 1]--;
                            res++;
                        }
                    }
                } else {
                    nums[i]--;
                    nums[i * 2]--;
                    nums[i * 2 + 1]--;
                    res++;
                }
            }
        }
        while (nums[len + 1] > 0) {
            nums[len + 1]--;
            res++;
        }
        System.out.println(res);
    }
}
