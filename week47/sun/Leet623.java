package me.algo.week47.sun;

/**
 * Created by Bomi on 2021/03/30.
 * 문제 출처 : https://leetcode.com/problems/add-one-row-to-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

public class Leet623 {
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        addOneRow(root, val, depth, 2);
        return root;
    }

    private void addOneRow(TreeNode root, int val, int depth, int currentDepth) {
        if (root == null) return;

        if (currentDepth != depth) {
            addOneRow(root.left, val, depth, currentDepth + 1);
            addOneRow(root.right, val, depth, currentDepth + 1);
            return;
        }

        TreeNode left = root.left;
        root.left = new TreeNode(val, left, null);

        TreeNode right = root.right;
        root.right = new TreeNode(val, null, right);
    }
}
