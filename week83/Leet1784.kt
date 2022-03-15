package me.algo.week83

/**
 * Created by Bomi on 2022/03/15.
 * 문제 출처 : https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet1784 {
    fun checkOnesSegment(s: String): Boolean {
        return !s.contains("01")
    }
}