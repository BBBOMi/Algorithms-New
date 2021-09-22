package me.algo.week66

/**
 * Created by Bomi on 2021/09/22.
 * 문제 출처 : https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : HashMap, Array
 */

class Leet442 {
    private val filterCount = 2
    fun findDuplicates(nums: IntArray): List<Int> {
        val countMap = HashMap<Int, Int>() // <number, count>
        nums.forEach {
            countMap[it] = countMap.getOrDefault(it, 0) + 1
        }
        return countMap.filterValues { it == filterCount }.keys.toList()
    }
}