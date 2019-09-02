package leetcode_test.t_22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<String>();
//        StringBuilder sb = new StringBuilder();
//        backtracking(ans, sb, 0, 0, n);
//        return ans;
//    }
//
//    private void backtracking(List<String> ans, StringBuilder s, int open, int close, int n) {
//        if (s.length() == 2 * n) {
//            ans.add(s.toString());
//            return;
//        }
//
//        if (open < n){
//            s.append("(");
//            backtracking(ans, s, open + 1, close, n);
//        }
//        if (close < open){
//            s.append(")");
//            backtracking(ans, s, open, close + 1, n);
//        }
//    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, "", 0, 0, n);

        return ans;
    }

    public void backtracking(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == 2 * max){
            ans.add(cur);
            return;
        }

        if (open < max){
            backtracking(ans, cur + "(", open + 1, close, max);
        }
        if (close < open){
            backtracking(ans, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}
