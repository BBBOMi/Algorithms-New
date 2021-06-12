package me.algo.week57

import kotlin.math.max

/**
 * Created by Bomi on 2021/06/10.
 * 문제 출처 : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP / Sliding Window
 * Used Data structure : Array
 */

class Leet1423 {

    // DP
    // Runtime : 340ms
    // Memory :  46.8MB
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val dp = IntArray(k + 1)
        ((cardPoints.size - k) until cardPoints.size).forEach {
            dp[0] += cardPoints[it]
        }

        (1..k).forEach {
            dp[it] = dp[it - 1] + cardPoints[it - 1] - cardPoints[(cardPoints.size - k) + (it - 1)]
        }
        return dp.max()!!
    }

    // Sliding Window
    // Runtime : 332ms
    // Memory : 48.3MB
    fun maxScore2(cardPoints: IntArray, k: Int): Int {
        var maxScore = 0
        (0 until k).forEach { maxScore += cardPoints[it] }

        var left = k - 1
        var right = cardPoints.lastIndex
        var score = maxScore
        while (left in 0..right) {
            score -= cardPoints[left--]
            score += cardPoints[right--]
            maxScore = max(maxScore, score)
        }
        return maxScore
    }
}