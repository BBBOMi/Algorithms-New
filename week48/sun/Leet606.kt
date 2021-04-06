package me.algo.week48.sun

/**
 * Created by Bomi on 2021/04/06.
 * 문제 출처 : https://leetcode.com/problems/construct-string-from-binary-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Tree
 * Used Data structure : TreeNode
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun tree2str(t: TreeNode?): String? {
    if (t == null) return ""
    if (t.left == null && t.right == null) return "${t.`val`}"
    return if (t.right == null) "${t.`val`}(${t.left})"
    else "${t.`val`}(${tree2str(t.left)})(${tree2str(t.right)})"
}