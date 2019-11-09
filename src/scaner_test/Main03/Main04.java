package scaner_test.Main03;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] w = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        int sum = 0;
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += w[i];
            max = Math.max(max, t[i]);
            if (sum >= m) {
                sum = 0;
                res += max;
                max = Integer.MIN_VALUE;
            }
        }
        System.out.println(res);
    }
}
