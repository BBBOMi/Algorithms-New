package me.algo.week70

/**
 * Created by Bomi on 2022/01/11.
 * 문제 출처 : https://leetcode.com/problems/sum-of-unique-elements/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

class Leet1748 {
    // 308ms (O(N*N))
    fun sumOfUnique(nums: IntArray): Int {
        return nums.filter { num -> nums.count { it == num } == 1 }.sum()
    }

    // 214ms O(N)
    fun sumOfUnique2(nums: IntArray): Int {
        val countMap = hashMapOf<Int, Int>()
        var answer = 0
        nums.forEach {
            countMap[it] = (countMap[it] ?: 0) + 1
            if (countMap[it] == 1) answer += it
            else if(countMap[it] == 2) answer -= it
        }
        return answer
    }

}