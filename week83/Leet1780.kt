package me.algo.week83

/**
 * Created by Bomi on 2022/03/15.
 * 문제 출처 : https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 *
 * Time Complexity : O(log3 N)
 * Used Algorithm : Math
 * Used Data structure : Set(LinkedHashSet)
 */

class Leet1780 {
    private companion object {
        const val BASE = 3
    }

    fun checkPowersOfThree(n: Int): Boolean {
        var answer = n
        val exponents = mutableSetOf<Int>()
        while (answer > 0) {
            val (exponent, value) = answer.getMaxPowersOfThree()

            if (exponents.contains(exponent)) return false
            exponents.add(exponent)
            answer -= value
        }
        return true
    }

    private fun Int.getMaxPowersOfThree(): Pair<Int, Int> { // (count, value)
        var value = 1
        var count = 0
        while (value * BASE <= this) {
            value *= BASE
            count++
        }
        return count to value
    }
}