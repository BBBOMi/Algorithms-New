package me.algo.week51.sun

import java.util.*

/**
 * Created by Bomi on 2021/04/28.
 * 문제 출처 : https://leetcode.com/problems/palindrome-linked-list/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Deque(ArrayDeque)
 */


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun isPalindrome(head: ListNode?): Boolean {
    val values = ArrayDeque<Int>()

    var temp = head
    while (temp != null) {
        values.add(temp.`val`)
        temp = temp.next
    }

    while (values.size > 1) {
        val first = values.pollFirst()
        val last = values.pollLast()
        if (first != last) return false
    }
    return true
}