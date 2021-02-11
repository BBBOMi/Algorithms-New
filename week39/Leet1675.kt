package me.algo.week39

import java.lang.Integer.min
import java.util.*


/**
 * Created by Bomi on 2021/02/11.
 * 문제 출처 : https://leetcode.com/problems/minimize-deviation-in-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sort
 * Used Data structure : TreeSet
 */

class Leet1675 {
    fun minimumDeviation(nums: IntArray): Int {
        val sortedNums = TreeSet<Int>()
        nums.forEach { if (isEven(it)) sortedNums.add(it) else sortedNums.add(it.times(2)) }

        var diff = Int.MAX_VALUE
        while (true) {
            diff = min(diff, sortedNums.last() - sortedNums.first())

            if (isEven(sortedNums.last())) {
                sortedNums.add(sortedNums.last().div(2))
                sortedNums.remove(sortedNums.last())
            } else return diff
        }
    }

    private fun isEven(x: Int) = (x.rem(2) == 0)
}