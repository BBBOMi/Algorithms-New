package me.algo.week54.sun

/**
 * Created by Bomi on 2021/05/20.
 * 문제 출처 : https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Tree
 * Used Data structure : Tree
 */

class Leet589 {
    inner class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun preorder(root: Node?): List<Int> {
        val answer = mutableListOf<Int>()
        preorder(root, answer)
        return answer
    }

    private fun preorder(root: Node?, values: MutableList<Int>) {
        root?.let {
            values.add(it.`val`)
            it.children.forEach { child ->
                preorder(child, values)
            }
        }
    }
}