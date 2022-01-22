package me.algo.week80

import java.util.*

/**
 * Created by Bomi on 2022/01/22.
 * 문제 출처 : https://leetcode.com/problems/maximum-score-from-removing-stones/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Heap
 * Used Data structure : Heap(PriorityQueue)
 */

class Leet1753 {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val maxHeap = PriorityQueue<Int>() { a, b -> b - a }
        maxHeap.offerIfPositive(a)
        maxHeap.offerIfPositive(b)
        maxHeap.offerIfPositive(c)

        var score = 0
        while (maxHeap.size > GAME_OVER_PILE_COUNT) {
            score++
            val first = maxHeap.poll()
            val second = maxHeap.poll()

            maxHeap.offerIfPositive(first - 1)
            maxHeap.offerIfPositive(second - 1)
        }
        return score
    }

    private fun PriorityQueue<Int>.offerIfPositive(num: Int) {
        this.takeIf { num > 0 }?.offer(num)
    }

    companion object {
        const val GAME_OVER_PILE_COUNT = 1
    }
}