package me.algo.week65

/**
 * Created by Bomi on 2021/09/06.
 * 문제 출처 : https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet915 {
    fun partitionDisjoint(nums: IntArray): Int {
        var leftLength = 1
        var leftMax = nums.first()
        var totalMax = nums.first()
        nums.forEachIndexed { index, it ->
            if (leftMax > it) {
                leftLength = index + 1
                leftMax = totalMax
            } else totalMax = maxOf(totalMax, it)
        }
        return leftLength
    }
}