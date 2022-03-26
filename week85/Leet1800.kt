package me.algo.week85

/**
 * Created by Bomi on 2022/03/26.
 * 문제 출처 : https://leetcode.com/problems/maximum-ascending-subarray-sum/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet1800 {
    fun maxAscendingSum(nums: IntArray): Int {
        var sum = nums[0]
        var maxSum = sum

        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i]
            } else {
                sum = nums[i]
            }
            maxSum = maxOf(maxSum, sum)
        }
        return maxSum
    }
}
