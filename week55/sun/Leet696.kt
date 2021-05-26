package me.algo.week55.sun

/**
 * Created by Bomi on 2021/05/26.
 * 문제 출처 : https://leetcode.com/problems/count-binary-substrings/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet696 {
    fun countBinarySubstrings(s: String): Int {
        var answer = 0
        var pre = 0
        var curr = 1
        (1..s.lastIndex).forEach {
            if (s[it - 1] == s[it]) curr++
            else {
                pre = curr
                curr = 1
            }

            if (pre >= curr) answer++
        }
        return answer
    }
}