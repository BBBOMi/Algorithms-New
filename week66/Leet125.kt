package me.algo.week66

/**
 * Created by Bomi on 2021/09/21.
 * 문제 출처 : https://leetcode.com/problems/valid-palindrome/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointers
 */

class Leet125 {
    fun isPalindrome(s: String): Boolean {
        return s.toLowerCase()
                .replace("[^a-z0-9]".toRegex(), "")
                .checkPalindrome()
    }

    private fun String.checkPalindrome(): Boolean {
        var left = 0
        var right = this.length - 1
        while (left < right) {
            if (this[left++] != this[right--]) return false
        }
        return true
    }
}