package me.algo.week56.sun

/**
 * Created by Bomi on 2021/05/31.
 * 문제 출처 : https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet1480 {
    fun runningSum(nums: IntArray): IntArray {
        (1 until nums.size).forEach {
            nums[it] = nums[it] + nums[it - 1]
        }
        return nums
    }
}