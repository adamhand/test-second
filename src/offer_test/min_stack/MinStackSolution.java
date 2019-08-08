package offer_test.min_stack;

import java.util.Stack;

public class MinStackSolution {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStackSolution minStack = new MinStackSolution();
        int[] nums = {3, 4, 2, 5, 1};

        for (int n : nums) {
            minStack.push(n);
        }
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
    }
}
