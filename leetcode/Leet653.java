package me.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/10/15.
 * 문제 출처 : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Time Complexity : O(N)
 * Used Algorithm : BST
 * Used Data structure : Tree, Set(HashSet)
 */

public class Leet653 {
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

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode node, int k, Set<Integer> set) {
        if(node == null) return false;
        if(set.contains(k - node.val)) return true;

        set.add(node.val);
        return find(node.left, k, set) || find(node.right, k, set);
    }
}
