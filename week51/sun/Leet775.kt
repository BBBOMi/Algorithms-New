package me.algo.week51.sun

import kotlin.math.abs

/**
 * Created by Bomi on 2021/05/01.
 * 문제 출처 : https://leetcode.com/problems/global-and-local-inversions/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

fun isIdealPermutation(nums: IntArray): Boolean {
    nums.forEachIndexed { index, item ->
        if (abs(item - index) > 1) return false
    }
    return true
}