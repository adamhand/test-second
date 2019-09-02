package scaner_test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        int i = 0, j = 0, k = 0;
        for (; i < line1.length() && j < line2.length(); i++) {
            sb.append(line1.charAt(i));

            if (k == 4) {
                k = 0;
                sb.append(line2.charAt(j));
                sb.append(' ');
                j = j + 2;
            }
            if (line1.charAt(i) != ' ')
                k++;
        }
        while (i < line1.length()) {
            sb.append(line1.charAt(i++));
        }
        while (j < line2.length()) {
            sb.append(' ');
            sb.append(line2.charAt(j++));
            j++;
        }
        System.out.println(sb.toString());
    }
}
