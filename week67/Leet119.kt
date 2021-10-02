package me.algo.week67

/**
 * Created by Bomi on 2021/10/02.
 * 문제 출처 : https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet119 {
    fun getRow(rowIndex: Int): List<Int> {
        val dp = Array<IntArray>(rowIndex + 1) {
            IntArray(rowIndex + 1) { if (it == 0) 1 else 0 } // 각 열의 0번째 인덱스 값 1로 채우기
        }

        for (i in 1..rowIndex) {
            for (j in 1..i) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] // Pascal의 삼각형
            }
        }
        return dp[rowIndex].toList()
    }
}