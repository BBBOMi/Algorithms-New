package me.algo.week56.wed

import kotlin.math.max
import kotlin.math.min

/**
 * Created by Bomi on 2021/06/03.
 * 문제 출처 :https://programmers.co.kr/learn/courses/30/lessons/77484
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

class P77484 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val winnings = win_nums.toHashSet()
        var zeroCount = 0
        lottos.forEach {
            if (it == 0) {
                zeroCount++
                return@forEach
            }
            winnings.remove(it)
        }

        val last = min(winnings.size + 1, 6)
        val first = max(last - zeroCount, 1)
        return intArrayOf(first, last)
    }

    fun solution2(lottos: IntArray, win_nums: IntArray): IntArray {
        return intArrayOf(
                lottos.size.plus(1) - lottos.filter { it == 0 || win_nums.contains(it) }.size,
                lottos.size.plus(1) - lottos.filter { win_nums.contains(it) }.size
        ).map { if (it > 6) it - 1 else it }.toIntArray()
    }
}