package me.algo.week70

import kotlin.math.absoluteValue

/**
 * Created by Bomi on 2022/01/12.
 * 문제 출처 : https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

class Leet1749 {
    fun maxAbsoluteSum(nums: IntArray): Int {
        val emptyValue = 0
        var maxSum = emptyValue
        var minSum = emptyValue
        var max = emptyValue

        nums.forEach {
            maxSum = maxOf(emptyValue, maxSum + it)
            minSum = minOf(emptyValue, minSum + it)
            max = maxOf(max, maxSum, minSum.absoluteValue)
        }
        return max
    }

    private fun maxOf(a: Int, b: Int, c: Int) =  maxOf(a, maxOf(b, c))
}