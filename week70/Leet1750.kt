package me.algo.week70

import java.util.*

/**
 * Created by Bomi on 2022/01/14.
 * 문제 출처 : https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Deqye(ArrayDeque)
 */

class Leet1750 {
    fun minimumLength(s: String): Int {
        val deque = ArrayDeque<Char>().apply {
            s.toCharArray().forEach { this.add(it) }
        }

        val minSize = 1
        while (minSize < deque.size) {
            if (!isSame(deque.peekFirst(), deque.peekLast())) break

            val target = deque.peekFirst()
            while (deque.isNotEmpty() && target == deque.peekFirst()) {
                deque.pollFirst()
            }
            while (deque.isNotEmpty() && target == deque.peekLast()) {
                deque.pollLast()
            }
        }
        return deque.size
    }

    private fun isSame(a: Char, b: Char) = a == b
}