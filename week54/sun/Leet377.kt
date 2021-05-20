package me.algo.week54.sun

/**
 * Created by Bomi on 2021/05/19.
 * 문제 출처 : https://leetcode.com/problems/combination-sum-iv/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1
        (1..target).forEach { index ->
            nums.forEach inner@{
                if (index < it) return@inner
                dp[index] += dp[index - it]
            }
        }
        return dp[target]
    }
}