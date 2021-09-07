package me.algo.week65

import kotlin.math.absoluteValue

/**
 * Created by Bomi on 2021/09/07.
 * 문제 출처 : https://leetcode.com/problems/3sum-closest/
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var answer = 1_000_000
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    if ((sum - target).absoluteValue < (answer - target).absoluteValue) {
                        answer = sum
                    }
                }
            }
        }
        return answer
    }
}