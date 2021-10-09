package me.algo.week67

/**
 * Created by Bomi on 2021/10/09.
 * 문제 출처 : https://leetcode.com/problems/h-index/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sorting
 * Used Data structure : Array
 */

class Leet274 {
    fun hIndex(citations: IntArray): Int {
        var h = citations.size
        while (true) {
            val highCount = citations.count { it >= h }
            if (highCount >= h) break
            h--
        }
        return h
    }
}