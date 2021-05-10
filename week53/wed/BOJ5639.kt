package me.algo.week53.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/07.
 * 문제 출처 : https://www.acmicpc.net/problem/5639
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DFS
 * Used Data structure : Tree
 */

private class TreeNode(
        val value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var root: TreeNode? = null
    while (true) {
        val input = readLine()
        if (input.isNullOrEmpty()) break
        root = insert(root, input.toInt())
    }

    val answer = StringBuilder()
    postorder(root, answer)
    println(answer.toString())
}

private fun insert(root: TreeNode?, value: Int): TreeNode {
    if (root == null) return TreeNode(value)
    if (value < root.value) root.left = insert(root.left, value)
    else root.right = insert(root.right, value)
    return root
}

private fun postorder(root: TreeNode?, result: StringBuilder) {
    root?.let {
        postorder(it.left, result)
        postorder(it.right, result)
        result.append("${it.value}\n")
    }
}