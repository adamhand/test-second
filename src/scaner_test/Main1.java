package scaner_test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode (int val) {
        this.val = val;
    }
}

public class Main1 {

    static TreeNode trueRoot = null;
    static StringBuilder sb = new StringBuilder();
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        initTree(input);
        inOrder(trueRoot, sb);
        return sb.toString();
    }

    static void inOrder (TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        inOrder(root.left, sb);
        sb.append((char)root.val);
        inOrder(root.right, sb);
    }

    static void initTree (String str) {
        if (str == "")
            return;

        TreeNode root = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        boolean isLeft = true;
        int curIndex = 0;
        while (curIndex < str.length()) {
            char ch = str.charAt(curIndex);
            switch (ch) {
                case '(' :
                    nodeStack.push(root);
                    isLeft = true;
                    break;
                case ')' :
                    isLeft = false;
                    if (!nodeStack.isEmpty()) {
                        nodeStack.pop();
                        break;
                    }
                case ',' :
                    isLeft = false;
                    break;
                default :
                    root = new TreeNode(Integer.valueOf(ch));
                    if (trueRoot == null) {
                        trueRoot = root;
                    } else {
                        if (!nodeStack.isEmpty()) {
                            TreeNode parentNode = nodeStack.peek();
                            if (isLeft) {
                                parentNode.left = root;
                            } else {
                                parentNode.right = root;
                            }
                        }
                    }
            }
            curIndex++;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}

// 参考https://blog.csdn.net/y_16041527/article/details/79772627
// https://blog.csdn.net/csjapan/article/details/79518061
