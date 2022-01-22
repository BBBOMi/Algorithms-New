package me.algo.week80

/**
 * Created by Bomi on 2022/01/22.
 * 문제 출처 : https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

class Leet1758 {
    fun minOperations(s: String): Int {
        return minOf(countChanges(s, '0', '1'), countChanges(s, '1', '0'))
    }

    private fun countChanges(s: String, first: Char, second: Char): Int {
        var count = 0
        s.forEachIndexed { index, c ->
            count += when {
                index.isEven() -> changeCount(c, first)
                else -> changeCount(c, second)
            }
        }
        return count
    }

    private fun Int.isEven() = this % 2 == 0

    private fun changeCount(from: Char, to: Char) = if (from == to) 0 else 1
}