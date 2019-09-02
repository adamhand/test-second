package scaner_test;

import java.util.Scanner;

public class Test4 {
    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            numSum(num);
            res[i] = flag;
        }

        for (boolean b : res)
            if (b)
                System.out.println(true);
            else
        System.out.println("false");
    }

    public static void numSum(int n){
        if (n == 1) {
            flag = true;
            return;
        } else {
            int num = 0;
            int x = 0;
            while (n>0){
                x = n%10;
                n = n/10;
                num += x*x;
            }
            numSum(num);
        }
    }
}
