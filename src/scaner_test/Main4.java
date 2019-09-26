package scaner_test;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n == 2 && m == 1) {

        }

        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int r1 = 0, c1 = 0, r2 = n - 1, c2 = m - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = r1; i <= r2; i++)
                System.out.printf("%d ", array[i][c1]);
            for (int i = c1 + 1; i <= c2; i++)
                System.out.printf("%d ", array[r2][i]);
            if (r1 != r2)
                for (int i = r2 - 1; i >= r1; i--)
                    System.out.printf("%d ", array[i][c2]);
            if (c1 != c2)
                for (int i = c2 - 1; i > c1; i--)
                    System.out.printf("%d ", array[r1][i]);
            r1++; r2--; c1++; c2--;
        }
    }
}
