package me.algo.week54.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/16.
 * 문제 출처 : https://www.acmicpc.net/problem/1629
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Recursive
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    fun pow(base: Int, exponent: Int, mod: Int): Long {
        return if (exponent == 1) base.toLong()
        else {
            val multiple = pow(base, exponent.div(2), mod)
            if (exponent.rem(2) == 0) (multiple * multiple) % mod
            else (((multiple * multiple) % mod) * base) % mod
        }
    }

    println(pow(a % c, b, c))
}