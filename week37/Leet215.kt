package me.algo.week37

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

class Leet215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sortedDescending()[k-1]
    }
}