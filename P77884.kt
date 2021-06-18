package me.algo

/**
 * Created by Bomi on 2021/06/18.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/77884
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Math
 */

class P77884 {
    fun solution(left: Int, right: Int): Int {
        return (left..right).fold(0) { acc, it ->
            val count = countDivisors(it)
            acc + if (isEven(count)) it else -1 * it
        }
    }

    private fun countDivisors(n: Int) = (1..n).filter { n % it == 0 }.size

    private fun isEven(n: Int) = n % 2 == 0
}