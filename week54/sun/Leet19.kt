package me.algo.week54.sun

/**
 * Created by Bomi on 2021/05/18.
 * 문제 출처 : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : LinkedList
 */

class Leet19 {
    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        fun index(node: ListNode?): Int {
            return when (node) {
                null -> 0
                else -> {
                    val i = index(node.next) + 1
                    if (i > n) {
                        node.next?.`val` = node.`val`
                    }
                    i
                }
            }
        }
        index(head)
        return head?.next
    }
}