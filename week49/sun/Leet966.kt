package me.algo.week49.sun


/**
 * Created by Bomi on 2021/04/22.
 * 문제 출처 : https://leetcode.com/problems/vowel-spellchecker/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Set(LinkedHashSet), Map(LinkedHashMap), Array
 */

class Leet966 {
    private lateinit var originWords: MutableSet<String>
    private lateinit var lowerCaseWords: MutableMap<String, String>
    private lateinit var withoutVowelsWords: MutableMap<String, String>

    private val EMPTY_STRING = ""

    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        originWords = mutableSetOf()
        lowerCaseWords = mutableMapOf()
        withoutVowelsWords = mutableMapOf()

        for (word in wordlist) {
            originWords.add(word)

            val lowerCase = word.toLowerCase()
            lowerCaseWords.putIfAbsent(lowerCase, word)

            val withoutVowels = removeVowels(lowerCase)
            withoutVowelsWords.putIfAbsent(withoutVowels, word)
        }
        return findWords(queries)
    }

    private fun findWords(queries: Array<String>): Array<String> {
        val answer = arrayOfNulls<String>(queries.size)
        for (i in 0 until queries.size) {
            answer[i] = find(queries[i])
        }
        return answer.requireNoNulls()
    }

    private fun find(query: String): String {
        if (originWords.contains(query)) return query

        val lowerCase = query.toLowerCase()
        if (lowerCaseWords.containsKey(lowerCase)) {
            return lowerCaseWords[lowerCase]!!
        }

        val withoutVowels = removeVowels(lowerCase)
        if (withoutVowelsWords.containsKey(withoutVowels)) {
            return withoutVowelsWords[withoutVowels]!!
        }

        return EMPTY_STRING
    }

    private fun removeVowels(str: String): String {
        return str.replace("[aeiou]".toRegex(), "_")
    }
}