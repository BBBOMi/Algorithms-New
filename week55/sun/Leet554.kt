package me.algo.week55.sun

import kotlin.math.max

/**
 * Created by Bomi on 2021/05/27.
 * 문제 출처 : https://leetcode.com/problems/brick-wall/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Hash
 * Used Data structure : Map(LinkedHashMap)
 */

class Leet554 {
    fun leastBricks(wall: List<List<Int>>): Int {
        val cuttingLineCounts = mutableMapOf<Int, Int>()
        var maxCuttingLineCount = 0
        wall.forEach { list ->
            var wallSum = 0
            (0 until list.lastIndex).forEach {
                wallSum += list[it]
                cuttingLineCounts[wallSum] = cuttingLineCounts.getOrDefault(wallSum, 0) + 1
                maxCuttingLineCount = max(maxCuttingLineCount, cuttingLineCounts[wallSum]!!)
            }
        }
        return wall.size - maxCuttingLineCount
    }
}