package me.algo.week52.sun

/**
 * Created by Bomi on 2021/05/06.
 * 문제 출처 : https://leetcode.com/problems/partition-list/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : LinkedList
 */

class Leet86 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        var left = ListNode(0)
        val leftHead = left
        var right = ListNode(0)
        val rightHead = right

        var temp = head
        while (temp != null) {
            when {
                temp.`val` < x -> {
                    left.next = ListNode(temp.`val`)
                    left = left.next!!
                }
                else -> {
                    right.next = ListNode(temp.`val`)
                    right = right.next!!
                }
            }
            temp = temp.next
        }

        left.next = rightHead.next
        return leftHead.next
    }
}