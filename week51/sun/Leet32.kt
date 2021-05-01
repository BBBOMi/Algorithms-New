package me.algo.week51.sun

import java.util.*

/**
 * Created by Bomi on 2021/05/01.
 * 문제 출처 : https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array, Stack
 */

class Leet32 {
    private val OPEN = '('
    fun longestValidParentheses(s: String): Int {
        return if (s.isEmpty() || s.length == 1) 0
        else {
            val count = IntArray(s.length + 1)
            val stack = Stack<Int>()

            s.forEachIndexed { index, c ->
                val current = index + 1
                if (c == OPEN) {
                    stack.push(current)
                } else {
                    if (stack.isNotEmpty()) {
                        val from = stack.pop()
                        val length = current - from + 1
                        count[current] = count[from - 1] + length
                    }
                }
            }
            count.max()!!
        }
    }
}