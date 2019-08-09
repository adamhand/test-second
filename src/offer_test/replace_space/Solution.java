package offer_test.replace_space;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P1 = oldLen - 1, P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world");
        System.out.println(new Solution().replaceSpace(sb));
    }
}
