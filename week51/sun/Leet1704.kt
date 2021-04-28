package me.algo.week51.sun

/**
 * Created by Bomi on 2021/04/28.
 * 문제 출처 : https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet1704 {
    fun halvesAreAlike(s: String): Boolean {
        val length = s.length
        val a = removeVowels(s.substring(0, length / 2))
        val b = removeVowels(s.substring(length / 2, length))
        return a.length == b.length
    }

    private val REGEX_VOWELS = "[aeiouAEIOU]"
    private fun removeVowels(s: String): String {
        return s.replace(REGEX_VOWELS.toRegex(), "")
    }
}
