package me.algo.week53.wed

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by Bomi on 2021/05/10.
 * 문제 출처 : https://www.acmicpc.net/problem/1167
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : List(ArrayList), Queue(LinkedList)
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val v = readLine()!!.toInt()
    val tree = Array(v + 1) { mutableListOf<Pair<Int, Int>>() } // <next vertex, distance>
    repeat(v) {
        val inputs = readLine()!!.split(" ").map { it.toInt() }
        val vertex = inputs[0]
        (1 until inputs.lastIndex step 2).forEach {
            val linkedVertex = inputs[it]
            val distance = inputs[it + 1]
            tree[vertex].add(Pair(linkedVertex, distance))
        }
    }
    val root = bfs(1, tree).first
    println(bfs(root, tree).second)
}

private const val NOT_VISITED = -1

private fun bfs(start: Int, tree: Array<MutableList<Pair<Int, Int>>>): Pair<Int, Int> {
    val distances = IntArray(tree.size) { NOT_VISITED }
    val queue: Queue<Int> = LinkedList()
    distances[start] = 0
    queue.offer(start)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        tree[current].forEach {
            val next = it.first
            if (distances[next] != NOT_VISITED) return@forEach

            val between = it.second
            distances[next] = distances[current] + between
            queue.offer(next)
        }
    }

    fun minPair(): Pair<Int, Int> {
        var maxIndex = 0
        distances.forEachIndexed { index, it ->
            if (distances[maxIndex] >= it) return@forEachIndexed
            maxIndex = index
        }
        return Pair(maxIndex, distances[maxIndex])
    }
    return minPair()
}