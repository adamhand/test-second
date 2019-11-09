package scaner_test;

import java.util.HashMap;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        HashMap<Integer, Integer> path = new HashMap<>();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();

                path.put(key, value);
            }

            int key = 1;
            int pathLength = 0;
            while (path.get(key) != null) {
                pathLength++;
                if (pathLength > 2) {
                    break;
                }

                int value = path.get(key);
                if (value == n) {
                    System.out.println("POSSIBLE");
                    break;
                } else {
                    key = value;
                }
            }
            if (pathLength > 2) {
                System.out.println("IMPOSSIBLE");
            }
            path.clear();
        }
    }
}
