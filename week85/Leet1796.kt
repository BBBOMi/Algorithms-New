package me.algo.week85

/**
 * Created by Bomi on 2022/03/26.
 * 문제 출처 : https://leetcode.com/problems/second-largest-digit-in-a-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array, List(ArrayList)
 */

class Leet1796 {
    fun secondHighest(s: String): Int {
        return s.toCharArray()
            .distinct()
            .filter { it.isDigit() }
            .map { Character.getNumericValue(it) }
            .sortedDescending()
            .second()
    }

    private fun List<Int>.second() = if (this.size < 2) -1 else this[1]
}
