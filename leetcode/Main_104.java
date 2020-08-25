package me.algo.leetcode;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Time Complexity : O(log N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

public class Main_104 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int count;

    public int maxDepth(TreeNode root) {
        count = 0;
        countDepth(root, 0);
        return count;
    }

    private static void countDepth(TreeNode root, int depth) {
        if(depth > count) count = depth;
        if(root == null) return;
        countDepth(root.left, depth + 1);
        countDepth(root.right, depth + 1);
    }

//    private static int maxDepth2(TreeNode root) {
//        if(root == null) return 0;
//        int leftDepth = maxDepth2(root.left);
//        int rightDepth = maxDepth2(root.right);
//        return Math.max(leftDepth, rightDepth) + 1;
//    }
}
