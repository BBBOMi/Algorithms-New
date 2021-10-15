package me.algo.week68

/**
 * Created by Bomi on 2021/10/15.
 * 문제 출처 : https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

class Leet1716 {
    private val daysOfWeek = 7
    fun totalMoney(n: Int): Int {
        var days = 0
        var totalMoney = 0
        while (++days <= n) {
            val weekStartMoney = (days - 1) / daysOfWeek + 1
            val todayMoney = weekStartMoney + ((days - 1) % daysOfWeek)
            totalMoney += todayMoney
        }
        return totalMoney
    }
}