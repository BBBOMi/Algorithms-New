package me.algo.week62

/**
 * Created by Bomi on 2021/08/03.
 * 문제 출처 : https://leetcode.com/problems/reduce-array-size-to-the-half/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Greedy
 * Used Data structure : Array, Map
 */

class Leet1338 {
    fun minSetSize(arr: IntArray): Int {
        val countMap = HashMap<Int, Int>() // <number, count>
        arr.forEach { countMap[it] = (countMap[it] ?: 0) + 1 }

        var totalCount = arr.size
        val half = totalCount / 2
        var answer = 0
        countMap.entries
                .sortedByDescending { it.value }
                .forEach {
                    answer++
                    totalCount -= it.value
                    if (totalCount <= half) return answer
                }
        return answer
    }
}