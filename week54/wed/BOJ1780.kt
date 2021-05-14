package me.algo.week54.wed

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by Bomi on 2021/05/14.
 * 문제 출처 : https://www.acmicpc.net/problem/1780
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Recursive
 * Used Data structure : Array
 */

private const val TYPE_NEGATIVE = -1
private const val TYPE_ZERO = 0
private const val TYPE_POSITIVE = 1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val papers = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(n) { st.nextToken().toInt() }
    }

    var negativeCount = 0
    var zeroCount = 0
    var positiveCount = 0
    fun countPapers(startX: Int, startY: Int, n: Int) {
        if (isAllTheSame(startX, startY, n, papers)) {
            when (papers[startX][startY]) {
                TYPE_NEGATIVE -> negativeCount++
                TYPE_ZERO -> zeroCount++
                TYPE_POSITIVE -> positiveCount++
            }
            return
        }

        val nextSize = n.div(3)
        countPapers(startX, startY, nextSize)
        countPapers(startX, startY + nextSize, nextSize)
        countPapers(startX, startY + nextSize.times(2), nextSize)
        countPapers(startX + nextSize, startY, nextSize)
        countPapers(startX + nextSize, startY + nextSize, nextSize)
        countPapers(startX + nextSize, startY + nextSize.times(2), nextSize)
        countPapers(startX + nextSize.times(2), startY, nextSize)
        countPapers(startX + nextSize.times(2), startY + nextSize, nextSize)
        countPapers(startX + nextSize.times(2), startY + nextSize.times(2), nextSize)
    }

    countPapers(0, 0, n)
    println("$negativeCount \n$zeroCount \n$positiveCount")
}

private fun isAllTheSame(startX: Int, startY: Int, n: Int, papers: Array<IntArray>): Boolean {
    val value = papers[startX][startY]
    val endX = startX + n
    val endY = startY + n
    (startX until endX).forEach { i ->
        (startY until endY).forEach { j ->
            if (papers[i][j] != value) return false
        }
    }
    return true
}