package me.algo.week52.sun

/**
 * Created by Bomi on 2021/05/03.
 * 문제 출처 : https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet953 {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val orderMap = IntArray(26)
        order.forEachIndexed { index, c -> orderMap[c - 'a'] = index }

        for (i in 0 until words.lastIndex) {
            for (j in words[i].indices) {
                if (j >= words[i + 1].length) return false

                if (words[i][j] != words[i + 1][j]) {
                    val currentWordCharIndex = words[i][j] - 'a'
                    val nextWordCharIndex = words[i + 1][j] - 'a'
                    return if (orderMap[currentWordCharIndex] > orderMap[nextWordCharIndex]) false else break
                }
            }
        }
        return true
    }
}
