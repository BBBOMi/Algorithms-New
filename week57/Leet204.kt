package me.algo.week57

import kotlin.math.sqrt

/**
 * Created by Bomi on 2021/06/10.
 * 문제 출처 : https://leetcode.com/problems/count-primes/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : 에라토스테네스의 체
 * Used Data structure : Array
 */

class Leet204 {
    private val minPrimeNumber = 2

    fun countPrimes(n: Int): Int {
        return if (n <= minPrimeNumber) 0
        else {
            val isPrimeNumbers = BooleanArray(n) { true }
            var compositionNumbersCount = 2 // 0, 1

            val limit = sqrt(n.toDouble()).toInt()
            (minPrimeNumber..limit).forEach {
                ((it + it) until n step it).forEach inner@{ num ->
                    if (!isPrimeNumbers[num]) return@inner
                    isPrimeNumbers[num] = false
                    compositionNumbersCount++
                }
            }
            n - compositionNumbersCount
        }
    }
}