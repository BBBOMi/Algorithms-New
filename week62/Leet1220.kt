package me.algo.week62

/**
 * Created by Bomi on 2021/08/03.
 * 문제 출처 : https://leetcode.com/problems/count-vowels-permutation/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

class Leet1220 {
    // a -> e  /  e, i, u -> a
    // e -> a, i  /  a, i -> e
    // i -> a, e, o, u  /  e, o -> i
    // o -> i, u  /  i -> o
    // u -> a  /  i, o -> u

    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n + 1) { LongArray(5) }
        dp[1].fill(1)

        for (i in 2..n) {
            dp[i][CHAR_a] = (dp[i - 1][CHAR_e] + dp[i - 1][CHAR_i] + dp[i - 1][CHAR_u]).rem(MOD)
            dp[i][CHAR_e] = (dp[i - 1][CHAR_a] + dp[i - 1][CHAR_i]).rem(MOD)
            dp[i][CHAR_i] = (dp[i - 1][CHAR_e] + dp[i - 1][CHAR_o]).rem(MOD)
            dp[i][CHAR_o] = dp[i - 1][CHAR_i].rem(MOD)
            dp[i][CHAR_u] = (dp[i - 1][CHAR_i] + dp[i - 1][CHAR_o]).rem(MOD)
        }
        return dp[n].reduce { total, count -> (total + count).rem(MOD) }.toInt()
    }

    private companion object {
        private const val CHAR_a = 0
        private const val CHAR_e = 1
        private const val CHAR_i = 2
        private const val CHAR_o = 3
        private const val CHAR_u = 4

        private const val MOD = 1_000_000_000 + 7
    }
}