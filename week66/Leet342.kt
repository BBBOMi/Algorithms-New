package me.algo.week66

import kotlin.math.ceil
import kotlin.math.ln

/**
 * Created by Bomi on 2021/09/21.
 * 문제 출처 : https://leetcode.com/problems/power-of-four/
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math
 */

class Leet342 {
    fun isPowerOfFour(n: Int): Boolean {
        return if (n == 0) false
        else {
            val x = n.log4()
            x == ceil(x)
        }
    }

    private fun Int.log4() = ln(this.toDouble()).div(ln(4.0))
}
