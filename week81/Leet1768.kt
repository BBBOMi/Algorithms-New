package me.algo.week81

import kotlin.math.max

/**
 * Created by Bomi on 2022/02/06.
 * 문제 출처 : https://leetcode.com/problems/merge-strings-alternately/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        var result = ""
        val maxLength = max(word1.length, word2.length)

        for(i in 0 until maxLength) {
            result += get(i, word1)
            result += get(i, word2)
        }
        return result
    }

    private fun get(index: Int, word: String): String {
        return if(index < word.length) word[index].toString() else ""
    }
}
