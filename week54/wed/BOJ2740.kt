package me.algo.week54.wed

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * Created by Bomi on 2021/05/14.
 * 문제 출처 : https://www.acmicpc.net/problem/2740
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (heightA, widthA) = readLine()!!.split(" ").map { it.toInt() }
    val arrA = Array(heightA) {
        val st = StringTokenizer(readLine())
        IntArray(widthA) { st.nextToken().toInt() }
    }

    val (heightB, widthB) = readLine()!!.split(" ").map { it.toInt() }
    val arrB = Array(heightB) {
        val st = StringTokenizer(readLine())
        IntArray(widthB) { st.nextToken().toInt() }
    }

    val result = Array(heightA) { IntArray(widthB) }
    fun multiply() {
        (0 until heightA).forEach { i ->
            (0 until widthB).forEach { j ->
                (0 until widthA).forEach { k ->
                    result[i][j] += arrA[i][k] * arrB[k][j]
                }
            }
        }
    }

    multiply()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    result.forEach { ints ->
        ints.forEach { bw.write("$it ") }
        bw.write("\n")
    }
    bw.close()
}