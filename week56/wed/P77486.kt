package me.algo.week56.wed

import kotlin.math.ceil

/**
 * Created by Bomi on 2021/06/05.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/77486
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

class P77486 {
    companion object {
        private const val CENTER = "-"

        private const val TOOTH_BRUSH_PRICE = 100
        private const val BENEFIT_PERCENTAGE = 0.9f
    }

    fun solution(enroll: Array<String>, referral: Array<String>, sellers: Array<String>, amount: IntArray): IntArray {
        val revenues = IntArray(enroll.size)
        sellers.forEachIndexed { index, seller ->
            calculateBenefit(seller, amount[index] * TOOTH_BRUSH_PRICE, revenues, enroll, referral)
        }
        return revenues
    }

    private fun calculateBenefit(name: String, price: Int, revenues: IntArray, enroll: Array<String>, referral: Array<String>) {
        if (name == CENTER) return

        val index = enroll.indexOf(name)
        val revenue = ceil(price * BENEFIT_PERCENTAGE).toInt()
        revenues[index] += revenue
        calculateBenefit(referral[index], price - revenue, revenues, enroll, referral)
    }
}