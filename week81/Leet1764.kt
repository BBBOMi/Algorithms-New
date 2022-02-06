package me.algo.week81

/**
 * Created by Bomi on 2022/02/06.
 * 문제 출처 : https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/
 *
 * Time Complexity : O(N*N)
 * Used Algorithm : Greedy
 */

class Leet1764 {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        val checked = IntArray(nums.size)
        var start = 0
        groups.forEachIndexed { order, group ->
            val index = matchedLastIndex(group, nums, start)
            if (index == -1) return false
            checked[index] = order
            start = index + 1
        }
        return true
    }

    private fun matchedLastIndex(group: IntArray, nums: IntArray, start: Int): Int {
        var finish = false
        for (i in start..(nums.size - group.size)) {
            for (j in group.indices) {
                if (nums[i + j] != group[j]) break
                if (j == group.lastIndex) finish = true
            }
            if (finish) return i + group.size - 1
        }
        return -1
    }
}
