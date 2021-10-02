package me.algo.week67

/**
 * Created by Bomi on 2021/10/02.
 * 문제 출처 : https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet171 {
    private val alphabetCount = 26
    fun titleToNumber(columnTitle: String): Int {
        var index = 0
        var digit = 1
        columnTitle.reversed()
                .forEach { c ->
                    val number = c - 'A' + 1
                    index += (number * digit)
                    digit *= alphabetCount
                }
        return index
    }
}