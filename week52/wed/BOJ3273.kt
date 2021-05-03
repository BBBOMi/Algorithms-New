package me.algo.week52.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/03.
 * 문제 출처 : https://www.acmicpc.net/problem/3273
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Two-Pointer
 * Used Data structure : Array
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()
    val x = readLine()!!.toInt()

    println(countPair(numbers, x))
}

private fun countPair(numbers: IntArray, x: Int): Int {
    var left = 0
    var right = numbers.lastIndex
    var count = 0
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        when {
            sum == x -> {
                count = count.inc()
                left = left.inc()
                right = right.dec()
            }
            sum < x -> left = left.inc()
            else -> right = right.dec()
        }
    }
    return count
}