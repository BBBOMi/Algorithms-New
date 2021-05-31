package me.algo.week55.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/26.
 * 문제 출처 : https://www.acmicpc.net/problem/14425
 *
 * Time Complexity : O(N + (M * log N))
 * Used Algorithm : Hash
 * Used Data structure : Map(LinkedHashMap)
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        map[readLine()] = 1
    }

    var count = 0
    repeat(m) {
        if (map.containsKey(readLine())) count++
    }
    println(count)
}