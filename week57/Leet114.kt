package me.algo.week57

/**
 * Created by Bomi on 2021/06/12.
 * 문제 출처 : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

class Leet114 {
    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var prev: TreeNode? = null

    fun flatten(root: TreeNode?) {
        root?.let {
            flatten(it.right)
            flatten(it.left)
            it.right = prev
            it.left = null
            prev = it
        }
    }
}