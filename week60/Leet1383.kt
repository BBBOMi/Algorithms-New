package me.algo.week60

import java.util.*
import kotlin.math.max

/**
 * Created by Bomi on 2021/07/15.
 * 문제 출처 : https://leetcode.com/problems/maximum-performance-of-a-team/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Greedy
 * Used Data structure : Queue(PriorityQueue), Array
 */

class Leet1383 {
    private val modulo = 1_000_000_000 + 7

    private class Engineer(
        val speed: Int,
        val efficiency: Int
    )

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        var result: Long = 0
        var speedSum: Long = 0
        val speedHeap = PriorityQueue<Int>()

        Array<Engineer>(n) { Engineer(speed[it], efficiency[it]) }
            .sortedByDescending { engineer -> engineer.efficiency }
            .forEach { engineer ->
                if (speedHeap.size == k) speedSum -= speedHeap.poll()

                speedHeap.offer(engineer.speed)
                speedSum += engineer.speed

                result = max(result, (speedSum * engineer.efficiency))
            }
        return result.rem(modulo).toInt()
    }
}