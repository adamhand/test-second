package scaner_test;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int res = getResult(array[i][0], array[i][1], array[i][2], array[i][3]);
            System.out.println(res);
        }
    }

    private static int getResult(int a, int b, int p, int q) {
        int res = 1;
        while (a <= b) {
            if (a + p >= b) {
                break;
            } else {
                p = p * q;
                res++;
            }
        }
        return res;
    }
}
