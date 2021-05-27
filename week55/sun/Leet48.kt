package me.algo.week55.sun

/**
 * Created by Bomi on 2021/05/27.
 * 문제 출처 : https://leetcode.com/problems/rotate-image/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        for (i in 0 until n) {
            for (j in (i + 1) until n) {
                swap(i, j, matrix)
            }
        }

        for (i in 0 until n / 2) {
            for (j in 0 until n) {
                swap(j, i, n - (i + 1), matrix)
            }
        }
    }

    private fun swap(i: Int, j: Int, matrix: Array<IntArray>) {
        val temp = matrix[i][j]
        matrix[i][j] = matrix[j][i]
        matrix[j][i] = temp
    }

    private fun swap(a: Pair<Int, Int>, b: Pair<Int, Int>, matrix: Array<IntArray>) {
        val temp = matrix[a.first][a.second]
        matrix[a.first][a.second] = matrix[b.first][b.second]
        matrix[b.first][b.second] = temp
    }

    private fun swap(row: Int, colA: Int, colB: Int, matrix: Array<IntArray>) {
        swap(Pair(row, colA), Pair(row, colB), matrix)
    }

}