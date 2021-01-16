package me.algo.week35;

/**
 * Created by Bomi on 2021/01/16.
 * 문제 출처 : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 */

public class Leet1008 {
    private static int currentIndex;

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

    public TreeNode bstFromPreorder(int[] preorder) {
        currentIndex = 0;
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int maxValue) {
        if (currentIndex >= preorder.length || preorder[currentIndex] > maxValue) return null;
        TreeNode root = new TreeNode(preorder[currentIndex++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, maxValue);
        return root;
    }

}
