package me.algo.week54.sun

import java.lang.Integer.min

/**
 * Created by Bomi on 2021/05/25.
 * 문제 출처 : https://leetcode.com/problems/triangle/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array, List(ArrayList)
 */

class Leet120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val maxValue = 10000 + 1
        val size = triangle.size
        val dp = Array(size) { IntArray(size) { maxValue } }
        triangle.forEachIndexed { i, list ->
            list.forEachIndexed { j, it ->
                when {
                    i == 0 -> dp[i][j] = it
                    j == 0 -> dp[i][j] = dp[i - 1][j] + it
                    else -> dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + it
                }
            }
        }
        return dp.last().min()!!
    }
}