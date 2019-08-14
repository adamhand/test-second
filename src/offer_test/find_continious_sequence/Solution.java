package offer_test.find_continious_sequence;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int left = 1, right = 2;
        int mid = (sum + 1) >> 1;
        int curSum = left + right;
        while (left < mid) {
            if (curSum == sum)
                result.add(storeSequence(left, right));
            while (curSum > sum) {
                curSum -= left;
                left--;
                if (curSum == sum)
                    result.add(storeSequence(left, right));
            }
            right++;
            curSum += right;
        }
        return result;
    }

    private ArrayList<Integer> storeSequence(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = l; i <= r; i++)
            list.add(i);

        return list;
    }

    public static void main(String[] args) {
        new Solution().FindContinuousSequence(4);
    }
}
