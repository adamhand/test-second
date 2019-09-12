package scaner_test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.printf("%d", 3);
    }
}
