package me.algo.week31

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Bomi on 2020/12/19.
 * 문제 출처 : https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : List(ArrayList)
 */

private const val PUSH_OPERATION = 0
private const val POP_OPERATION = 1

private const val MAX_SIZE = 10

private const val OVERFLOW = "overflow"
private const val UNDERFLOW = "underflow"

class Goorm43218 {
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val maxCount: Int = sc.nextInt()

        val stack = ArrayList<Int>()
        loop@ for (count in 0 until maxCount) {
            val operation = sc.nextInt()
            when (operation) {
                PUSH_OPERATION -> {
                    val added = sc.nextInt()
                    if (stack.size >= MAX_SIZE) println(OVERFLOW)
                    else stack.add(added)
                }
                POP_OPERATION -> {
                    if (stack.isEmpty()) println(UNDERFLOW)
                    else stack.removeAt(stack.size - 1)
                }
                else -> break@loop
            }
        }
        for (item in stack) print("$item ")
    }
}