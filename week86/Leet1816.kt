package me.algo.week86

/**
 * Created by Bomi on 2022/04/16.
 * 문제 출처 : https://leetcode.com/problems/truncate-sentence/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : List
 */

class Leet1816 {
    fun truncateSentence(s: String, k: Int): String {
        return s.split(" ")
            .filter { !it.startsWithNumber() }
            .subList(0, k)
            .joinToString(separator = " ")
    }

    private fun String.startsWithNumber() = this[0].isDigit()
}
