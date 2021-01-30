package me.algo.week37

import java.util.*

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Stack
 */

class Leet1673 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stack = Stack<Int>()
        val size = nums.size
        for (i in nums.indices) {
            while (stack.isNotEmpty() && nums[i] < stack.peek() && (k - stack.size) < (size - i)) {
                stack.pop()
            }
            if (stack.size < k) stack.push(nums[i])
        }
        return stack.toIntArray()
    }
}