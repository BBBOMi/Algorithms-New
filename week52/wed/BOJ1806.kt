package me.algo.week52.wed

import java.io.InputStreamReader
import java.lang.Integer.min


/**
 * Created by Bomi on 2021/05/04.
 * 문제 출처 : https://www.acmicpc.net/problem/1806
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Array
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    println(countSubArray(s, n, numbers))
}

private fun countSubArray(goal: Int, size: Int, numbers: IntArray): Int {
    var left = 0
    var right = 0
    var sum = 0
    var count = Int.MAX_VALUE
    while ((left <= right)) {
        if (sum >= goal) {
            count = min(count, right - left)
            sum = sum.minus(numbers[left++])
            continue
        }
        if (right == size) break
        sum = sum.plus(numbers[right++])
    }
    return if (count == Int.MAX_VALUE) 0 else count
}