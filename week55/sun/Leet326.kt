package me.algo.week55.sun

import kotlin.math.log10

/**
 * Created by Bomi on 2021/05/26.
 * 문제 출처 : https://leetcode.com/problems/power-of-three/
 *
 * Time Complexity : ?
 * Used Algorithm : Math
 */

class Leet326 {
    private val THREE = 3.0
    fun isPowerOfThree(n: Int): Boolean {
        return (log10(n.toDouble()) / log10(THREE)).rem(1) == 0.0
    }
}