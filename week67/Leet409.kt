package me.algo.week67

/**
 * Created by Bomi on 2021/10/02.
 * 문제 출처 : https://leetcode.com/problems/longest-palindrome/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet409 {
    fun longestPalindrome(s: String): Int {
        val countMap = HashMap<Char, Int>()

        var length = 0
        s.forEach {
            countMap[it] = countMap.getOrDefault(it, 0) + 1
            if (countMap[it]!! % 2 == 0) {
                length += 2
            }
        }
        return length + if (hasOddCase(countMap)) 1 else 0
    }

    private fun hasOddCase(countMap: HashMap<Char, Int>) = countMap.values.any { it % 2 == 1 }
}