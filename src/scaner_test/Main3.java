package scaner_test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rNum = sc.nextInt();
        int bNum = sc.nextInt();

        if (rNum == 0) {
            System.out.printf("%.5f", 0.00000f);
            return;
        } else if (bNum == 0 && rNum != 0) {
            System.out.printf("%.5f", 1.00000f);
            return;
        }
    }
}
