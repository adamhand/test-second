package scaner_test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] res = new boolean[n];
        sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");
            flag = hasToUpdate(strs[0], strs[1]);
            res[i] = flag;
        }
        for (boolean b : res)
            if (b)
                System.out.println("true");
            else
                System.out.println("false");
    }

    private static boolean hasToUpdate(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == '.' && s2.charAt(j) == '.') {
                i++;
                j++;
                continue;
            }
            if (s1.charAt(i) > s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        if (i == s1.length() && j < s2.length()) {
            while (j < s2.length()) {
                if (s2.charAt(j) != 0 && s2.charAt(j) != '.')
                    return true;
                j++;
            }
            return false;
        } else if (j == s2.length() && i < s1.length()) {
            return false;
        }
        return true;
    }
}
