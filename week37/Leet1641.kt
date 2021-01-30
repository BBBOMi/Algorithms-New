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
    /*
        u   o   i   e   a
        1 + 1 + 1 + 1 + 1 = 5
        1 + 2 + 3 + 4 + 5 = 15
        1 + 3 + 6 + 10 + 15 = 35
        1 + 4 + 10 + 20 + 35 = 70
     */
    private val vowelsCount = 5

    fun countVowelStrings(n: Int): Int {
        val matrix = Array<IntArray>(n + 1) { IntArray(vowelsCount + 1) }
        matrix[1].fill(1)
        matrix[1][0] = 0

        for (i in 2..n) {
            for (j in 1..vowelsCount) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]
            }
        }
        return matrix[n].sum()
    }
}