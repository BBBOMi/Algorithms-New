package me.algo.week82

/**
 * Created by Bomi on 2022/03/01.
 * 문제 출처 : https://leetcode.com/problems/count-items-matching-a-rule/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : List
 */

class Leet1773 {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val filterIndex = when (ruleKey) {
            "type" -> 0
            "color" -> 1
            else -> 2
        }

        return items.filter { it[filterIndex] == ruleValue }.size
    }
}