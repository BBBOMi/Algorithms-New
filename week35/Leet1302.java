package me.algo.week35;

/**
 * Created by Bomi on 2021/01/16.
 * 문제 출처 : https://leetcode.com/problems/deepest-leaves-sum/submissions/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 */

public class Leet1302 {
    private static int maxDepth;
    private static int sum;

    public class TreeNode {
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

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode root, int currentDepth) {
        if (root == null) return;

        if (maxDepth == currentDepth) sum += root.val;
        if (maxDepth < currentDepth) {
            maxDepth = currentDepth;
            sum = root.val;
        }

        deepestLeavesSum(root.left, currentDepth + 1);
        deepestLeavesSum(root.right, currentDepth + 1);
    }
}
