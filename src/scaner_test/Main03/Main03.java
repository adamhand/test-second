package scaner_test.Main03;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] w = new int[n + 1];
        int[] t = new int[n + 1];
        w[0] = 0;
        t[0] = 0;

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
        }

//        int sum = 0;
//        int res = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            sum += w[i];
//            max  = Math.max(max, t[i]);
//            if (sum >= m) {
//                sum = 0;
//                res += max;
//                max = Integer.MIN_VALUE;
//            }
//        }
//        System.out.println(res);
        int[][] f = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < m+1; j++){
                f[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (w[i] > j){
                    f[i][j] = f[i-1][j];
                }else {
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-w[i]]+t[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
