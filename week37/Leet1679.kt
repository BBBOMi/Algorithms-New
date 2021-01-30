package me.algo.week37

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/max-number-of-k-sum-pairs/
 *
 * Time Complexity : O(n log N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Array
 */

class Leet1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()

        var result = 0
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            when {
                sum > k -> right--
                sum < k -> left++
                else -> {
                    result++
                    right--
                    left++
                }
            }
        }
        return result
    }
}