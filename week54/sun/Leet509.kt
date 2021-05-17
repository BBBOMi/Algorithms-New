package me.algo.week54.sun

/**
 * Created by Bomi on 2021/05/17.
 * 문제 출처 : https://leetcode.com/problems/fibonacci-number/
 *
 * Time Complexity : O(2^N) / O(N)
 * Used Algorithm : Math
 */

class Leet509 {
    // 136 ms
    fun fib(n: Int): Int {
        return when {
            n <= 1 -> n
            else -> fib(n - 1) + fib(n - 2)
        }
    }

    // 136 ms
    fun fib2(n: Int): Int {
        return when {
            n <= 1 -> n
            else -> {
                var pre = 0
                var curr = 1
                (2..n).forEach { _ ->
                    val sum = pre + curr
                    pre = curr
                    curr = sum
                }
                curr
            }
        }
    }
}