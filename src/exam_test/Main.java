package exam_test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strs = s.split(",");
        int n = Integer.parseInt(strs[strs.length - 1].split(";")[1]);
        strs[strs.length - 1] = strs[strs.length - 1].split(";")[0];
        int num0 = 0, num1 = 0;
        for (int ii = 0; ii < strs.length; ii++) {
            int temp = Integer.parseInt(strs[ii]);
            if ((temp & 0x01) == 0) {
                num0++;
            } else {
                num1++;
            }
        }
        Integer[] nums0 = new Integer[num0];
        Integer[] nums1 = new Integer[num1];
        int i = 0, j = 0;
        for (String num : strs) {
            int k = Integer.parseInt(num);
            if ((k & 0x01) == 0) {
                nums0[i++] = k;
            } else {
                nums1[j++] = k;
            }
        }

        Arrays.sort(nums0, new MyComparator());
        Arrays.sort(nums1, new MyComparator());
        StringBuilder sb = new StringBuilder();

        if (n <= nums0.length) {
            for (int m = 0; m < n; m++) {
                sb.append(String.valueOf(nums0[m]));
                if (m != n - 1)
                    sb.append(",");
            }
        } else {
            int temp = n - nums0.length - 1;
            for (int m : nums0) {
                sb.append(String.valueOf(m));
                sb.append(",");
            }
            for (int m = 0; m < temp; m++) {
                sb.append(String.valueOf(nums1[m]));
                if (m != temp - 1)
                    sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
