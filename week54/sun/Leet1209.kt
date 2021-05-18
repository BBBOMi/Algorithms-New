package me.algo.week54.sun

import java.util.*

/**
 * Created by Bomi on 2021/05/18.
 * 문제 출처 : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Stack
 * Used Data structure : Stack
 */

class Leet1209 {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<Pair<Char, Int>>()
        s.forEach {
            if (stack.isEmpty() || stack.peek().first != it) {
                stack.push(Pair(it, 1))
            } else {
                stack.push(Pair(it, stack.pop().second + 1))
            }
            if (stack.peek().second == k) {
                stack.pop()
            }
        }

        fun toJoinString(): String {
            var result = ""
            stack.forEach { p ->
                repeat(p.second) {
                    result += p.first
                }
            }
            return result
        }
        return toJoinString()
    }
}