package me.algo.week52.sun

import kotlin.math.max

/**
 * Created by Bomi on 2021/05/08.
 * 문제 출처 : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS, DP
 * Used Data structure : Array
 */

class Leet329 {
    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        var length = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }
        matrix.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, _ ->
                length = max(length, getPathLength(i, j, matrix, dp))
            }
        }
        return length
    }

    private fun getPathLength(x: Int, y: Int, matrix: Array<IntArray>, dp: Array<IntArray>): Int {
        return if (dp[x][y] != 0) dp[x][y]
        else {
            var maxLength = 1
            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (nextX < 0 || nextX >= matrix.size || nextY < 0 || nextY >= matrix[0].size) continue
                if (matrix[x][y] >= matrix[nextX][nextY]) continue
                maxLength = max(maxLength, getPathLength(nextX, nextY, matrix, dp) + 1)
            }
            dp[x][y] = maxLength
            dp[x][y]
        }
    }
}