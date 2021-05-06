package me.algo.week53.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/06.
 * 문제 출처 : https://www.acmicpc.net/problem/11725
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Array, List(ArrayList)
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val n = readLine()!!.toInt()
    val nodes = arrayOfNulls<MutableList<Int>>(n + 1)
    repeat(n - 1) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        if (nodes[a] == null) nodes[a] = mutableListOf()
        if (nodes[b] == null) nodes[b] = mutableListOf()
        nodes[a]!!.add(b)
        nodes[b]!!.add(a)
    }

    val parent = IntArray(n + 1)
    dfs(1, nodes, parent, BooleanArray(n + 1))
    for (i in 2..n) {
        println(parent[i])
    }
}

private fun dfs(start: Int, nodes: Array<MutableList<Int>?>, parent: IntArray, visited: BooleanArray) {
    visited[start] = true
    nodes[start]?.forEach {
        if (visited[it]) return@forEach
        parent[it] = start
        dfs(it, nodes, parent, visited)
    }
}