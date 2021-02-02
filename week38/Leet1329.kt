package me.algo.week38

import java.util.*

/**
 * Created by Bomi on 2021/02/01.
 * 문제 출처 : https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Sort
 * Used Data structure : Array, Map(LinkedHashMap), PriorityQueue
 */

class Leet1329 {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        if (mat.size <= 1) return mat

        val col = mat.size
        val row = mat[0].size
        val map = mutableMapOf<Int, PriorityQueue<Int>>()
        for (i in 0 until col) {
            for (j in 0 until row) {
                val key = i - j
                map.putIfAbsent(key, PriorityQueue())
                map[key]!!.add(mat[i][j])
            }
        }
        for (i in 0 until col) {
            for (j in 0 until row) {
                mat[i][j] = map[i - j]!!.poll()
            }
        }
        return mat
    }
}