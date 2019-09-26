package scaner_test;


import java.util.Scanner;

public class Main100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, getResult(i));
        }
        System.out.println(ans);
    }

    private static int getResult(int n) {
        int res = 1;
        while (n > 0) {
            int temp = n % 10;
            res *= temp;
            n /= 10;
        }
        return res;
    }
}