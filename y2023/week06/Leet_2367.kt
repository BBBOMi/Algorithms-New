package me.algo.y2023.week06

/**
 * Created by Bomi on 2023/08/04.
 * 문제 출처 : https://leetcode.com/problems/number-of-arithmetic-triplets/
 *
 * Time Complexity : O(log N)
 * Used Algorithm : binary search
 * Used Data structure : Array
 *
 * Runtime: 160ms / Memory: 36.89MB
 */

fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    var count = 0
    for (i in nums.size - 1 downTo (0)) {
        val current = nums[i]

        nums.findIndex(current - diff, fromIndex = 0, toIndex = i)
            ?.let { nums.findIndex(nums[it] - diff, fromIndex = 0, toIndex = it) }
            ?.let { count++ }
    }

    return count
}

fun IntArray.findIndex(value: Int, fromIndex: Int, toIndex: Int) = run {
    this.binarySearch(value, fromIndex, toIndex).takeIf { it >= 0 }
}


fun main() {
    assert(
        arithmeticTriplets(intArrayOf(0, 1, 4, 6, 7, 10), 3) == 2
    )
    assert(
        arithmeticTriplets(intArrayOf(4, 5, 6, 7, 8, 9), 2) == 2
    )
}

