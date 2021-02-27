package me.algo.week41;

/**
 * Created by Bomi on 2021/02/27.
 * 문제 출처 : https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

public class Leet538 {
    static class TreeNode {
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

    private static int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
