package offer_test.verify_sequence;


public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int left, int right) {
        if (right - left <= 1) {
            return true;
        }
        int node = sequence[right];
        int cutIndex = left;
        while (cutIndex < right && sequence[cutIndex] <= node) {
            cutIndex++;
        }
        for (int i = cutIndex; i < right; i++) {
            if (sequence[i] < node) {
                return false;
            }
        }
        return verify(sequence, left, cutIndex - 1) && verify(sequence, cutIndex, right - 1);
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 4 ,5};
        System.out.println(new Solution().VerifySquenceOfBST(nums));
    }
}

