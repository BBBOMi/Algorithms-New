package me.algo.week63

/**
 * Created by Bomi on 2021/08/26.
 * 문제 출처 : https://leetcode.com/problems/custom-sort-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet791 {
    fun customSortString(order: String, s: String): String {
        val charCounts = IntArray(26) // alphabet count
        s.forEach { charCounts[it - 'a']++ }

        val sb = StringBuilder()
        order.forEach { current ->
            val index = current - 'a'
            (0 until charCounts[index]).forEach { _ ->
                sb.append(current)
            }
            charCounts[index] = 0
        }

        charCounts.forEachIndexed { index, count ->
            (0 until count).forEach { _ ->
                sb.append('a' + index)
            }
        }
        return sb.toString()
    }
}