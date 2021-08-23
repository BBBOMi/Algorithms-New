package me.algo.week63

import kotlin.math.max

/**
 * Created by Bomi on 2021/08/23.
 * 문제 출처 : https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet718 {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        var maxLength = 0
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        for (i in nums1.lastIndex downTo 0) {
            for (j in nums2.lastIndex downTo 0) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1
                    maxLength = max(maxLength, dp[i][j])
                }
            }
        }
        return maxLength
    }
}