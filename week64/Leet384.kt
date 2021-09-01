package me.algo.week64

/**
 * Created by Bomi on 2021/09/01.
 * 문제 출처 : https://leetcode.com/problems/shuffle-an-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array, List
 */

class Leet384 {
    class Solution(nums: IntArray) {
        val arr = nums

        /** Resets the array to its original configuration and return it. */
        fun reset(): IntArray {
            return arr
        }

        /** Returns a random shuffling of the array. */
        fun shuffle(): IntArray {
            return arr.copyOf()
                    .asList()
                    .shuffled()
                    .toIntArray()
        }

    }
}