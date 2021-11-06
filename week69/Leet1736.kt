package me.algo.week69

/**
 * Created by Bomi on 2021/11/06.
 * 문제 출처 : https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 *
 * Time Complexity : O(1)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet1736 {
    fun maximumTime(time: String): String {
        val answer = time.toCharArray()
        (1 until time.length).forEach {
            answer[it] = setTime(answer, it)
        }
        return answer.joinToString("")
    }

    private fun setTime(time: CharArray, index: Int): Char {
        return if (time[index] != '?') time[index]
        else {
            when (index) {
                0 -> {
                    if(time[1] == '?' || time[1] < '4') '2'
                    else '1'
                }
                1 -> {
                    if (time[0] == '2') '3'
                    else '9'
                }
                3 -> '5'
                4 -> '9'
                else -> ':'
            }
        }
    }
}