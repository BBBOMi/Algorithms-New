package me.algo.week62

/**
 * Created by Bomi on 2021/08/04.
 * 문제 출처 : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class Leet378 {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        return matrix
                .flatMap { it.asIterable() }
                .sorted()[k - 1]
    }
}