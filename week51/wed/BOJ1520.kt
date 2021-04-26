package me.algo.week51.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/04/26.
 * 문제 출처 : https://www.acmicpc.net/problem/1520
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

private const val NOT_VISITED = -1

fun main() = with(InputStreamReader(System.`in`)) {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(height) { IntArray(width) }
    val dp = Array(height) { IntArray(width) }

    for (i in 0 until height) {
        readLine()!!.split(" ").forEachIndexed { j, it ->
            map[i][j] = it.toInt()
            dp[i][j] = NOT_VISITED
        }
    }
    println(dfs(0, 0, map, dp))
}

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

private fun dfs(x: Int, y: Int, map: Array<IntArray>, dp: Array<IntArray>): Int {
    if (x == (map.size - 1) && y == (map[0].size - 1)) return 1
    if (dp[x][y] == -1) {
        dp[x][y] = 0
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX < 0 || nextX >= map.size || nextY < 0 || nextY >= map[0].size) continue
            if (map[x][y] <= map[nextX][nextY]) continue
            dp[x][y] += dfs(nextX, nextY, map, dp)
        }
    }
    return dp[x][y]
}