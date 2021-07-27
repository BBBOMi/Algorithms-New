package me.algo.week61

import java.util.*


/**
 * Created by Bomi on 2021/07/27.
 * 문제 출처 : https://leetcode.com/problems/my-calendar-i/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : 자료구조
 * Used Data structure : TreeMap
 */

class Leet729 {
    private class MyCalendar() {
        private val times = TreeMap<Int, Int>()

        fun book(start: Int, end: Int): Boolean {
            val pre = times.floorKey(start)
            val next = times.ceilingKey(start)
            return if ((pre == null || times[pre]!! <= start)
                    && (next == null || end <= next)) {
                times[start] = end
                true
            } else false
        }
    }
}