package me.algo.week42

/**
 * Created by Bomi on 2021/03/07.
 * 문제 출처 : https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet1337 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        var index = 0
        return mat.map { array -> array.filter { it == 1 }.count() }
                .map { Pair(index++, it) }
                .sortedBy { it.second }
                .map { it.first }
                .subList(0, k)
                .toIntArray()
    }
}