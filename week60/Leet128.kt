package me.algo.week60

/**
 * Created by Bomi on 2021/07/14.
 * 문제 출처 : https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Set(HashSet)
 */

class Leet128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var maxLength = 0
        set.forEach {
            if (it - 1 in set) return@forEach

            var current = it
            var length = 1
            while (++current in set) { // 현재보다 큰 것만 탐색
                length++
            }

            maxLength = maxOf(maxLength, length)
        }
        return maxLength
    }
}