package scaner_test;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int a = n, b = m;
        int ans = Integer.MAX_VALUE;
        while (a >= 0 && b >= 0) {
            if ((n - a) * (m - b) <= k) {
                ans = Math.min(ans, a + b);
            } else {
                break;
            }

            if (b > 0) {
                b--;
            } else if (a > 0) {
                a--;
            } else {
                break;
            }
        }
        System.out.print(ans);
    }
}
