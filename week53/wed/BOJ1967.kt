package me.algo.week53.wed

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by Bomi on 2021/05/14.
 * 문제 출처 : https://www.acmicpc.net/problem/1967
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, List(ArrayList), Queue(PriorityQueue)
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val root = Array(n + 1) { mutableListOf<Pair<Int, Int>>() } // <number, weight>
    repeat(n - 1) {
        val (parent, child, weight) = readLine()!!.split(" ").map { it.toInt() }
        root[parent].add(Pair(child, weight))
        root[child].add(Pair(parent, weight))
    }

    fun findFarthestPair(start: Int): Pair<Int, Int> {
        val visited = BooleanArray(n + 1)
        val queue: Queue<Pair<Int, Int>> = PriorityQueue { p1, p2 -> p2.second - p1.second }
        queue.offer(Pair(start, 0))
        visited[start] = true

        var farthestPair = Pair(start, 0)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            farthestPair = if (current.second > farthestPair.second) current else farthestPair

            root[current.first].forEach {
                if (visited[it.first]) return@forEach
                visited[it.first] = true
                queue.offer(Pair(it.first, current.second + it.second))
            }
        }
        return farthestPair
    }

    val farthestPair = findFarthestPair(1)
    println(findFarthestPair(farthestPair.first).second)
}

