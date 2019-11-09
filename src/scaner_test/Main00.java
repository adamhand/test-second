package scaner_test;

import java.util.Scanner;

public class Main00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        for (int num : array) {
            int res = num;
            while (true) {
                int temp = getSum(res);
                if (temp < num) {
                    res++;
                } else {
                    break;
                }
            }
            System.out.println(res);
        }
    }

    private static int getSum(int n) {
        int sum = 0;
        int num = n;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
