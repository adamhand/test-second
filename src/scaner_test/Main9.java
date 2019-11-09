package scaner_test;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int fA = sc.nextInt();
        int fB = sc.nextInt();

        int[][] array = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int k = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            k = Math.min(k, fA * array[i][2] + fB * array[i][3]);
        }

        System.out.print(k);
    }
}
