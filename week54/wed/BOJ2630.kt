package me.algo.week54.wed

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by Bomi on 2021/05/13.
 * 문제 출처 : https://www.acmicpc.net/problem/2630
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Recursive
 * Used Data structure : Array
 */

private const val BLUE = true
private const val WHITE = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val papers = Array(n) { BooleanArray(n) }
    (0 until n).forEach { i ->
        val row = StringTokenizer(readLine())
        (0 until n).forEach { j ->
            val token = row.nextToken().toInt()
            papers[i][j] = if (token == 0) WHITE else BLUE
        }
    }

    var whiteCount = 0
    var blueCount = 0
    fun count(n: Int, start: Pair<Int, Int>, end: Pair<Int, Int>, papers: Array<BooleanArray>) {
        if (start.first < 0 || start.second < 0) return
        if (end.first > papers.size || end.second > papers.size) return
        if (isAllTheSame(start, end, papers)) {
            if (papers[start.first][start.second] == WHITE) whiteCount++
            else blueCount++
            return
        }

        val half = n.div(2)
        count(half, Pair(start.first, start.second), Pair(end.first - half, end.second - half), papers)
        count(half, Pair(start.first, start.second + half), Pair(end.first - half, end.second), papers)
        count(half, Pair(start.first + half, start.second), Pair(end.first, end.second - half), papers)
        count(half, Pair(start.first + half, start.second + half), Pair(end.first, end.second), papers)
    }

    count(n, Pair(0, 0), Pair(n, n), papers)
    println(whiteCount)
    println(blueCount)
}

private fun isAllTheSame(start: Pair<Int, Int>, end: Pair<Int, Int>, papers: Array<BooleanArray>): Boolean {
    val paper = papers[start.first][start.second]
    (start.first until end.first).forEach { i ->
        (start.second until end.second).forEach { j ->
            if (papers[i][j] != paper) return false
        }
    }
    return true
}
