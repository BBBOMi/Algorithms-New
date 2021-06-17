package me.algo

/**
 * Created by Bomi on 2021/06/17.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/76501
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

class P76501 {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        return absolutes.foldIndexed(0) { index, acc, it -> acc + if (signs[index]) it else it * -1 }
    }
}