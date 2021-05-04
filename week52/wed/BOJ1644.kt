package me.algo.week52.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/04.
 * 문제 출처 : https://www.acmicpc.net/problem/1644
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Two-pointer, 에라토스테네스의 체
 * Used Data structure : Array
 */

fun main() = with(InputStreamReader(System.`in`)) {
    val n = readLine()!!.toInt()
    val primes = filterPrimes(n)
    println(countCase(n, primes))
}

private fun filterPrimes(n: Int): IntArray {
    val numbers = BooleanArray(n + 1)
    numbers[0] = true
    numbers[1] = true
    var primeCount = n
    for (i in 2..n) {
        for (j in (i + i)..n step i) {
            if (!numbers[j]) primeCount = primeCount.dec()
            numbers[j] = true
        }
    }

    var i = 0
    val primes = IntArray(primeCount)
    numbers.forEachIndexed { index, b -> if (!b) primes[i++] = index }
    return primes
}

private fun countCase(n: Int, primes: IntArray): Int {
    var left = 0
    var right = 0
    var sum = 0
    var count = 0
    while ((right < primes.size)) {
        if (sum < n) {
            sum = sum.plus(primes[right])
            right = right.inc()
            continue
        }
        if (sum == n) count = count.inc()

        sum = sum.minus(primes[left])
        left = left.inc()
    }
    return count
}