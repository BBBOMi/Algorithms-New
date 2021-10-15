package me.algo.week68

/**
 * Created by Bomi on 2021/10/15.
 * 문제 출처 : https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

class Leet1710 {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        var size = truckSize
        var answer = 0
        boxTypes.sortedByDescending { it[1] }
                .forEach {
                    if (size <= 0) return answer
                    val count = minOf(size, it[0])
                    answer += count * it[1]
                    size -= count
                }
        return answer
    }
}