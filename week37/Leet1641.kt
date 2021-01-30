package me.algo.week37

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/count-sorted-vowel-strings/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet1641 {
    // 1 + 1 + 1 + 1 + 1 = 5
    // 5 + 4 + 3 + 2 + 1 = 15
    // 15 + 10 + 6 + 3 + 1 = 35
    // 35 + 20 + 10 + 4 + 1 = 70
    private val vowelsCount = 5

    fun countVowelStrings(n: Int): Int {
        val matrix = Array<IntArray>(n + 1) { IntArray(vowelsCount) }
        matrix[1].fill(1)

        for (i in 2..n) {
            var sum = 0
            for (j in (vowelsCount - 1) downTo 0) {
                sum += matrix[i - 1][j]
                matrix[i][j] = sum
            }
        }
        return matrix[n].sum()
    }
}