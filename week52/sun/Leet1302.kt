package me.algo.week52.sun

/**
 * Created by Bomi on 2021/05/08.
 * 문제 출처 : https://leetcode.com/problems/deepest-leaves-sum/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

class Leet1302 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var deepestDepth = 0
    private var sum = 0
    fun deepestLeavesSum(root: TreeNode?): Int {
        deepestDepth = 0
        sum = 0
        deepestLeavesSum(root, deepestDepth)
        return sum
    }

    private fun deepestLeavesSum(root: TreeNode?, currentDepth: Int) {
        root?.let {
            if (deepestDepth == currentDepth) {
                sum += it.`val`
            }
            if (deepestDepth < currentDepth) {
                deepestDepth = currentDepth
                sum = it.`val`
            }
            deepestLeavesSum(it.left, currentDepth + 1)
            deepestLeavesSum(it.right, currentDepth + 1)
        }
    }
}