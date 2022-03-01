package me.algo.week82

import kotlin.math.absoluteValue

/**
 * Created by Bomi on 2022/03/01.
 * 문제 출처 : https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * Time Complexity : O(N * N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet1769 {
    fun minOperations(boxes: String): IntArray {
        val counts = IntArray(boxes.length)
        for (i in boxes.indices) {
            if (boxes[i] != EXIST) continue

            for (j in boxes.indices) {
                counts[j] += (i - j).absoluteValue
            }
        }
        return counts
    }

    companion object {
        private const val EXIST = '1'
    }
}