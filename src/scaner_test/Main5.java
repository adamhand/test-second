package scaner_test;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = 0, i = 0, j = 0;
        int sum = 0;
        while (i < n && j < n) {
            sum += nums[j++];
            if (sum <= s) {
                ans = Math.max(ans, j - i);
            } else {
                sum -= nums[i++];
            }
        }
        System.out.printf("%d", ans);
    }
}
