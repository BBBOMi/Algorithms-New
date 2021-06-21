package me.algo.week58

import kotlin.math.max

/**
 * Created by Bomi on 2021/06/21.
 * 문제 출처 : https://leetcode.com/problems/longest-string-chain/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array, List(ArrayList)
 */

class Leet1048 {
    fun longestStrChain(words: Array<String>): Int {
        return if (words.isEmpty()) 0
        else {
            val countMap = HashMap<String, Int>()
            var result = 0

            words.sortedBy { it.length }
                .forEach {
                    if (countMap.containsKey(it)) return@forEach
                    countMap[it] = 1

                    it.forEachIndexed { index, _ ->
                        val sub = it.removeRange(index, index + 1)

                        if (!countMap.containsKey(sub)) return@forEachIndexed
                        countMap[it] = max(countMap[sub]!! + 1, countMap[it]!!)
                    }
                    result = max(result, countMap[it]!!)
                }
            result
        }
    }
}