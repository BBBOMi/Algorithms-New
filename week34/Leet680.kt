package me.algo.week34


/**
 * Created by Bomi on 2021/01/09.
 * 문제 출처 : https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-Pointer
 */

class Leet680 {
    fun validPalindrome(s: String): Boolean {
        var left = -1
        var right = s.length
        while (++left < --right) {
            if (s[left] == s[right]) continue
            return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right)
        }
        return true
    }

    private fun validPalindrome(s: String, from: Int, to: Int): Boolean {
        var left = from
        var right = to
        while (++left < --right) {
            if (s[left] == s[right]) continue
            return false
        }
        return true
    }

}