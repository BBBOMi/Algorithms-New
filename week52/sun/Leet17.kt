package me.algo.week52.sun

/**
 * Created by Bomi on 2021/05/06.
 * 문제 출처 : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Time Complexity : O(3 ^ N)
 * Used Algorithm : Backtracking
 * Used Data structure : List(ArrayList), Map(LinkedHashMap)
 */

class Leet17 {
    private lateinit var characterMap: MutableMap<Char, String>
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        initMap()
        val result = mutableListOf<String>()
        dfs(digits, 0, StringBuilder(), result)
        return result
    }

    private fun dfs(digits: String, currentIndex: Int, word: StringBuilder, words: MutableList<String>) {
        if (currentIndex == digits.length) {
            words.add(word.toString())
            return
        }

        characterMap[digits[currentIndex]]?.forEach {
            word.append(it)
            dfs(digits, currentIndex + 1, word, words)
            word.deleteCharAt(currentIndex)
        }
    }

    private fun initMap() {
        characterMap = mutableMapOf()
        characterMap['2'] = "abc"
        characterMap['3'] = "def"
        characterMap['4'] = "ghi"
        characterMap['5'] = "jkl"
        characterMap['6'] = "mno"
        characterMap['7'] = "pqrs"
        characterMap['8'] = "tuv"
        characterMap['9'] = "wxyz"
    }
}