package me.algo.week57


/**
 * Created by Bomi on 2021/06/12.
 * 문제 출처 : https://leetcode.com/problems/ambiguous-coordinates/
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : String
 * Used Data structure : List(ArrayList)
 */

class Leet816 {
    fun ambiguousCoordinates(s: String): List<String> {
        val startIndex = 1
        val endIndex = s.lastIndex

        val result = mutableListOf<String>()
        ((startIndex + 1) until endIndex).forEach { index ->
            val heads = subStringList(s.substring(startIndex, index))
            val tails = subStringList(s.substring(index, endIndex))

            if (heads.isEmpty() || tails.isEmpty()) return@forEach
            heads.forEach { head ->
                tails.forEach { tail ->
                    result.add("($head, $tail)")
                }
            }
        }
        return result
    }

    private fun subStringList(s: String): List<String> {
        return if (s.length == 1) listOf(s)
        else {
            val ans = mutableListOf<String>()
            if (!s.startsWith("0")) {
                ans.add(s)
                var i = 0
                while (!s.endsWith("0") && ++i < s.length) {
                    ans.add(markingDotString(s.substring(0, i), s.substring(i)))
                }
            } else if (!s.endsWith("0")) {
                ans.add(markingDotString(s.substring(0, 1), s.substring(1)))
            }
            ans
        }
    }

    private fun markingDotString(head: String, tail: String) = "$head.$tail"
}