package me.algo.week62

import kotlin.math.absoluteValue


/**
 * Created by Bomi on 2021/08/02.
 * 문제 출처 : https://leetcode.com/problems/find-k-closest-elements/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Array, List
 */

class Leet658 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var left = 0
        var right = arr.lastIndex
        while (right - left >= k) {
            if ((arr[left] - x).absoluteValue > (arr[right] - x).absoluteValue) left++
            else right--
        }
        return (left..right).map { arr[it] }.toList()
    }
}