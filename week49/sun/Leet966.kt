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
    private val originWords: MutableSet<String> = mutableSetOf()
    private val lowerCaseWords: MutableMap<String, String> = mutableMapOf()
    private val withoutVowelsWords: MutableMap<String, String> = mutableMapOf()

    private val EMPTY_STRING = ""

    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        wordlist.forEach {
            originWords.add(it)

            val lowerCase = it.toLowerCase()
            lowerCaseWords.putIfAbsent(lowerCase, it)

            val withoutVowels = removeVowels(lowerCase)
            withoutVowelsWords.putIfAbsent(withoutVowels, it)
        }
        return findWords(queries)
    }

    private fun findWords(queries: Array<String>): Array<String> {
        val answer = arrayOfNulls<String>(queries.size)
        for (i in queries.indices) {
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