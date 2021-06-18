package me.algo

import java.util.*

/**
 * Created by Bomi on 2021/06/18.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12978
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Dijkstra
 * Used Data structure : Array, Queue(PriorityQueue)
 */

class P12978 {
    data class Village(
        val from: Int,
        val distance: Int
    )

    fun solution(n: Int, roads: Array<IntArray>, k: Int): Int {
        val distances = IntArray(n + 1) { Int.MAX_VALUE }

        val queue = PriorityQueue<Village> { v1, v2 -> v1.distance - v2.distance }
        queue.offer(Village(1, 0))
        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (distances[current.from] <= current.distance) continue
            distances[current.from] = current.distance

            roads.filter { it[0] == current.from || it[1] == current.from }
                .forEach {
                    if (it[0] == current.from) queue.offer(Village(it[1], current.distance + it[2]))
                    else queue.offer(Village(it[0], current.distance + it[2]))
                }
        }

        return distances.filter { it <= k }.size
    }
}