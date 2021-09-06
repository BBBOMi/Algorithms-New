package me.algo.week65

/**
 * Created by Bomi on 2021/09/06.
 * 문제 출처 : https://leetcode.com/problems/binary-tree-pruning/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

class Leet814 {
    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private val retainValue = 1
    fun pruneTree(root: TreeNode?): TreeNode? {
        return root?.let {
            it.left = pruneTree(it.left)
            it.right = pruneTree(it.right)

            if (it.`val` == retainValue || it.left != null || it.right != null) it
            else null
        }
    }
}