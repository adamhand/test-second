package scaner_test;

import java.util.LinkedList;
import java.util.Scanner;

public class Main02 {
    private static int result = 1;
    private static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] array = new int[m];
            for (int j = 0; j < m; j++) {
                array[j] = sc.nextInt();
            }
            getResult(array);
            list.add(result);
            result = 1;
        }

        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void getResult(int[] array) {
        int res = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                result = Math.max(result, res);
               continue;
            }
            int sum = getSum(array, i - 1);
            if (sum <= array[i]) {
                res++;
            } else {
                result = Math.max(result, res);
            }
        }
    }

    private static int getSum(int[] arrray, int i) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += arrray[j];
        }
        return sum;
    }
}
