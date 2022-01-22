package me.algo.week80

/**
 * Created by Bomi on 2022/01/22.
 * 문제 출처 : https://leetcode.com/problems/count-number-of-homogenous-substrings/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet1759 {
    fun countHomogenous(s: String): Int {
        var answer = 0
        var count = 0
        var pre = '0'
        s.forEach { c ->
            count = if (c == pre) count + 1 else 1
            answer = (answer + count) % MODULO
            pre = c
        }

        return answer
    }

    private companion object {
        const val MODULO = 1_000_000_000 + 7
    }
}