package me.algo.week51.sun

import kotlin.math.abs

/**
 * Created by Bomi on 2021/05/03.
 * 문제 출처 : https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */


fun minOperations(n: Int): Int {
    var count = if(n.rem(2) == 0) 1 else 0
    repeat((n - 1).div(2)) {
        val value = it.times(2).inc()
        count += abs(n - value)
    }
    return count
}