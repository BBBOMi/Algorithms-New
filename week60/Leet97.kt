package me.algo.week60

/**
 * Created by Bomi on 2021/07/12.
 * 문제 출처 : https://leetcode.com/problems/interleaving-string/
 *
 * Time Complexity : O(N + M)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

class Leet97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        return if (s1.length + s2.length != s3.length) false
        else dfs(s1, s2, s3, 0, 0, 0, Array(s1.length + 1) { BooleanArray(s2.length + 1) })
    }

    private fun dfs(
        s1: String, s2: String, s3: String, s1Index: Int, s2Index: Int, s3Index: Int, invalid: Array<BooleanArray>
    ): Boolean {
        return when  {
            invalid[s1Index][s2Index] -> false
            s3Index == s3.length -> true
            else -> {
                val validation = (s1Index < s1.length) && (s1[s1Index] == s3[s3Index]) && dfs(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, invalid)
                        || (s2Index < s2.length) && (s2[s2Index] == s3[s3Index]) && dfs(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, invalid)
                invalid[s1Index][s2Index] = !validation
                validation
            }
        }
    }
}