package me.algo.week49.wed

import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/04/07.
 * 문제 출처 : https://www.acmicpc.net/problem/3036
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : List(ArrayList)
 */


fun main(args: Array<String>) = with(InputStreamReader(System.`in`)) {
    val n: Int = readLine()!!.toInt()
    val rounds = readLine()!!.split(" ").map { it.toInt() }

    val sb = StringBuilder()
    val standard = rounds[0]
    for (i in 1 until rounds.size) {
        val gcd = gcd(standard, rounds[i])
        sb.append("${standard / gcd}/${rounds[i] / gcd} \n")
    }
    println(sb.toString())
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
