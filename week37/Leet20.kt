package me.algo.week37

import java.util.*

/**
 * Created by Bomi on 2021/01/30.
 * 문제 출처 : https://leetcode.com/problems/valid-parentheses/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Stack
 */

class Leet20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            if (isOpenBracket(it)) stack.push(it)
            else {
                if (stack.isEmpty()) return false
                if (!isSameType(stack.peek(), it)) return false
                stack.pop()
            }
        }
        return stack.isEmpty()
    }

    private fun isOpenBracket(bracket: Char): Boolean {
        return bracket == '(' || bracket == '{' || bracket == '['
    }

    private fun isSameType(open: Char, close: Char): Boolean {
        return open == '(' && close == ')' ||
                open == '{' && close == '}' ||
                open == '[' && close == ']'
    }
}