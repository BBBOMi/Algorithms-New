package me.algo.week40.sun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/02/20.
 * 문제 출처 : https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : List(ArrayList), Tree
 */

public class Leet199 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;

        if (list.size() == depth) list.add(root.val);

        dfs(root.right, depth + 1, list);
        dfs(root.left, depth + 1, list);
    }
}
