package me.algo.week38

/**
 * Created by Bomi on 2021/02/05.
 * 문제 출처 : https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet1437 {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        return kLengthApart(nums, k, 0, k)
    }

    fun kLengthApart(nums: IntArray, k: Int, currentIndex: Int, step: Int): Boolean {
        if (currentIndex >= nums.size) return true
        if (nums[currentIndex] == 0) return kLengthApart(nums, k, currentIndex + 1, step + 1)
        return if (step < k) false
        else kLengthApart(nums, k, currentIndex + 1, 0)
    }
}