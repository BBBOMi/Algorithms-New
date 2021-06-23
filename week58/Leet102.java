package me.algo.week58;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/06/23.
 * 문제 출처 : https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

public class Leet102 {
    private static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        var answer = new ArrayList<List<Integer>>();
        levelOrder(root, 0, answer);
        return answer;
    }

    private void levelOrder(TreeNode root, int depth, List<List<Integer>> answer) {
        if (root == null) return;
        if (answer.size() <= depth) {
            answer.add(depth, new ArrayList<>());
        }
        answer.get(depth).add(root.val);

        levelOrder(root.left, depth + 1, answer);
        levelOrder(root.right, depth + 1, answer);
    }
}
