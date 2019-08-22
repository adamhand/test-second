package offer_test.print_min_number;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("111");
        sb.append("222");
        String[] strs = new String[2];
        strs[0] = "111";
        strs[1] = "222";

        String s = strs.toString();
        System.out.println(s);
        System.out.println(strs[0]);

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        System.out.println(list.get(0));


    }
}
