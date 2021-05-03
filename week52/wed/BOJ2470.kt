package me.algo.week52.wed

import java.io.InputStreamReader
import kotlin.math.abs

/**
 * Created by Bomi on 2021/05/03.
 * 문제 출처 : https://www.acmicpc.net/problem/2470
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Array
 */

private const val STANDARD = 0
fun main() = with(InputStreamReader(System.`in`)) {
    val n = readLine()!!.toInt()
    val water = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()
    val result = findWaterPair(water)
    println("${result.first} ${result.second}")
}

private fun findWaterPair(water: IntArray): Pair<Int, Int> {
    var min = 0
    var max = water.lastIndex
    var minPair = Pair(water[min], water[max])
    while (min < max) {
        val sum = water[min] + water[max]
        minPair = closeToStandard(minPair, Pair(water[min], water[max]))
        when {
            sum == STANDARD -> return Pair(water[min], water[max])
            sum < STANDARD -> min = min.inc()
            else -> max = max.dec()
        }
    }
    return minPair
}

private fun closeToStandard(a: Pair<Int, Int>, b: Pair<Int, Int>): Pair<Int, Int> {
    val sumA = abs(a.first + a.second)
    val sumB = abs(b.first + b.second)
    return if (sumA < sumB) a else b
}