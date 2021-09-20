package me.algo.week66

/**
 * Created by Bomi on 2021/09/20.
 * 문제 출처 : https://leetcode.com/problems/detect-capital/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet520 {
    fun detectCapitalUse(word: String): Boolean {
        return word == word.toUpperCase()
                || word == word.toLowerCase()
                || word == word[0].toUpperCase().plus(word.substring(1).toLowerCase())
    }
}