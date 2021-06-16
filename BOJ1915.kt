package me.algo

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

/**
 * Created by Bomi on 2021/06/16.
 * 문제 출처 : https://www.acmicpc.net/problem/1915
 *
 * Time Complexity : O(N * M)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (height, width) = readLine().split(" ").map { it.toInt() }
    val matrix = Array(height + 1) { IntArray(width + 1) }

    (1..height).forEach { i ->
        readLine().forEachIndexed { j, char ->
            matrix[i][j + 1] = char.toString().toInt()
        }
    }

    println(biggestSquareArea(height, width, matrix))
}

private fun biggestSquareArea(height: Int, width: Int, matrix: Array<IntArray>): Int {
    val dp = Array(height + 1) { IntArray(width + 1) }
    var size = 0
    (1..height).forEach { i ->
        (1..width).forEach rows@{ j ->
            if (matrix[i][j] != 1) return@rows

            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
            size = max(size, dp[i][j])
        }
    }
    return size * size
}

private fun min(a: Int, b: Int, c: Int) = min(a, min(b, c))