package me.algo.week51.wed

import java.io.InputStreamReader
import kotlin.math.min

/**
 * Created by Bomi on 2021/04/23.
 * 문제 출처 : https://www.acmicpc.net/problem/11066
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val t = readLine()!!.toInt()
    repeat(t) {
        val k = readLine()!!.toInt()
        val cost = IntArray(k + 1)
        val sum = IntArray(k + 1)

        readLine()!!.split(" ").map { it.toInt() }.forEachIndexed { index, item ->
            cost[index + 1] = item
            sum[index + 1] = sum[index].plus(item)
        }

        println(solution(k, sum))
    }
}

fun solution(k: Int, sum: IntArray): Int {
    val dp = Array(k + 1) { IntArray(k + 1) }
    for (diff in 1 until k) {
        for (start in 1..(k - diff)) {
            val end = start + diff
            dp[start][end] = Int.MAX_VALUE

            for (mid in start until end) {
                dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1])
            }
        }
    }
    return dp[1][k]
}