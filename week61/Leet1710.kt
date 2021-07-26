package me.algo.week61

import kotlin.math.min

/**
 * Created by Bomi on 2021/07/26.
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
        boxTypes.sortedByDescending { it[1] } // is the number of units in each box of the type i.
                .forEach {
                    val count = min(it[0], size)
                    answer += count * it[1]
                    size -= count
                    if (size == 0) return answer
                }
        return answer
    }
}