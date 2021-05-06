package me.algo.week53.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/06.
 * 문제 출처 : https://www.acmicpc.net/problem/1991
 *
 * Time Complexity : O(N)
 * Used Algorithm : Recursion
 * Used Data structure : Tree
 */


private const val EMPTY_VALUE = "."

class Node(
        val name: String,
        var leftChild: Node? = null,
        var rightChild: Node? = null
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val root = Node("A")
    repeat(n) {
        val (name, left, right) = readLine()!!.split(" ")
        insertNode(root, name, left, right)
    }

    val sb = StringBuilder()
    preorder(root, sb)
    sb.append("\n")

    inorder(root, sb)
    sb.append("\n")

    postorder(root, sb)

    println(sb.toString())
}

private fun insertNode(root: Node, name: String, leftChild: String, rightChild: String) {
    if (root.name == name) {
        if (leftChild != EMPTY_VALUE) root.leftChild = Node(leftChild)
        if (rightChild != EMPTY_VALUE) root.rightChild = Node(rightChild)
        return
    }
    root.leftChild?.let { insertNode(it, name, leftChild, rightChild) }
    root.rightChild?.let { insertNode(it, name, leftChild, rightChild) }
}

private fun preorder(root: Node?, result: StringBuilder) {
    root?.let {
        result.append(it.name)
        preorder(it.leftChild, result)
        preorder(it.rightChild, result)
    }
}

private fun inorder(root: Node?, result: StringBuilder) {
    root?.let {
        inorder(it.leftChild, result)
        result.append(it.name)
        inorder(it.rightChild, result)
    }
}

private fun postorder(root: Node?, result: StringBuilder) {
    root?.let {
        postorder(it.leftChild, result)
        postorder(it.rightChild, result)
        result.append(it.name)
    }
}