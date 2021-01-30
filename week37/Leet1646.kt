package me.algo.week37

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/get-maximum-in-generated-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet1646 {
    fun getMaximumGenerated(n: Int): Int {
        if(n <= 1) return n

        val nums = IntArray(n + 1)
        nums[1] = 1
        for (i in 2..n) {
            nums[i] = nums[i / 2]
            if (i % 2 != 0) nums[i] += nums[(i + 1) / 2]
        }
        return nums.max()!!
    }
}