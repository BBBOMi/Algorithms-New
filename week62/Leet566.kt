package me.algo.week62

/**
 * Created by Bomi on 2021/08/02.
 * 문제 출처 : https://leetcode.com/problems/reshape-the-matrix/
 *
 * Time Complexity : O(r * c)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet566 {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val array = mat.flatMap { it.asIterable() }.toTypedArray()
        if (array.size != r * c) return mat

        var index = 0
        return Array(r) { IntArray(c) { array[index++] } }
    }
}