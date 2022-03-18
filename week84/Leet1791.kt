package me.algo.week84

/**
 * Created by Bomi on 2022/03/18.
 * 문제 출처 : https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Graph
 * Used Data structure : Array, Map(LinkedHashMap)
 */

class Leet1791 {
    private companion object {
        private const val FROM = 0
        private const val TO = 1
    }

    fun findCenter(edges: Array<IntArray>): Int {
        val heads = mutableMapOf<Int, Int>()

        edges.forEach { edge ->
            val from = edge[FROM]
            val to = edge[TO]
            heads[from] = heads.getOrDefault(from, 0) + 1
            heads[to] = heads.getOrDefault(to, 0) + 1
        }

        return heads.entries.maxBy { it.value }!!.key
    }
}