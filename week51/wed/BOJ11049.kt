package me.algo.week51.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/04/23.
 * 문제 출처 : https://www.acmicpc.net/problem/11049
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val n = readLine()!!.toInt()
    val arr = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val input = readLine()!!.split(" ")
        arr[i][0] = input[0].toInt()
        arr[i][1] = input[1].toInt()
    }

    println(solution(n, arr))
}

fun solution(n: Int, arr: Array<IntArray>): Int {
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in 1 until n) {
        dp[i][i + 1] = arr[i][0] * arr[1][1] * arr[1 + 1][1]
    }

    for (diff in 2..n) {
        for (start in 1..(n - diff)) {
            val end = start + diff
            for (mid in start until end) {
                val count = dp[start][mid] + dp[mid + 1][end] + (arr[start][0] * arr[mid][1] * arr[end][1])
                if (dp[start][end] == 0 || count < dp[start][end]) dp[start][end] = count
            }
        }
    }
    return dp[1][n]
}