package me.algo.week54.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/13.
 * 문제 출처 : https://www.acmicpc.net/problem/1992
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Recursive
 * Used Data structure : Array
 */

private const val WHITE = 0
private const val BLACK = 1

private const val COMPRESSION_START = '('
private const val COMPRESSION_END = ')'

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val screen = Array(n) { IntArray(n) }
    (0 until n).forEach { i ->
        readLine().toCharArray()
                .forEachIndexed { j, c ->
                    screen[i][j] = if (c == '0') WHITE else BLACK
                }
    }

    fun compression(startX: Int, startY: Int, n: Int): String {
        if (startX < 0 || startY < 0 || (startX + n) > screen.size || (startY + n) > screen.size) return ""
        if (isAllTheSame(startX, startY, n, screen)) return screen[startX][startY].toString()

        val half = n.div(2)
        return COMPRESSION_START +
                compression(startX, startY, half) +
                compression(startX, startY + half, half) +
                compression(startX + half, startY, half) +
                compression(startX + half, startY + half, half) +
                COMPRESSION_END
    }

    println(compression(0, 0, n))
}

private fun isAllTheSame(startX: Int, startY: Int, n: Int, screen: Array<IntArray>): Boolean {
    val point = screen[startX][startY]
    val endX = startX + n
    val endY = startY + n
    (startX until endX).forEach { i ->
        (startY until endY).forEach { j ->
            if (screen[i][j] != point) return false
        }
    }
    return true
}