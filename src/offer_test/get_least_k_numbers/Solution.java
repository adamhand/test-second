package offer_test.get_least_k_numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0)
            return null;

        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        heap.add(1);
        heap.add(2);
        System.out.println(heap.peek());

        return null;
    }

    public static void main(String[] args) {
        new Solution().GetLeastNumbers_Solution(new int[] {1,2,3}, 3);
    }
}
