package me.algo.week55.sun

/**
 * Created by Bomi on 2021/05/28.
 * 문제 출처 : https://leetcode.com/problems/unique-paths-ii/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val width = obstacleGrid.first().size
        val dp = IntArray(width)
        dp[0] = 1

        obstacleGrid.forEach { arr ->
            arr.forEachIndexed { index, it ->
                dp[index] = when {
                    it == 1 -> 0
                    index == 0 -> dp[index]
                    else -> dp[index] + dp[index - 1]
                }
            }
        }
        return dp.last()
    }
}