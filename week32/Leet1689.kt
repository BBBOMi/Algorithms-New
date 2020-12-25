package me.algo.week32

import kotlin.math.max

/**
 * Created by Bomi on 2020/12/25.
 * 문제 출처 : https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

class Leet1689 {
    fun minPartitions(n: String): Int {
        var maxValue: Int = 0
        n.toCharArray().forEach {
            maxValue = max(maxValue, Character.getNumericValue(it))
        }
        return maxValue
    }
}