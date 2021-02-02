package me.algo.week38

import java.util.*

/**
 * Created by Bomi on 2021/02/02.
 * 문제 출처 : https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : PriorityQueue, (ListNode)
 */

class Leet23 {
    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val ascendingList = PriorityQueue<Int>()

        lists.forEach {
            it.let {
                var node = it
                while (node != null) {
                    ascendingList.add(node.`val`)
                    node = node.next
                }
            }
        }

        var root = ListNode(0)
        var temp = root
        while (ascendingList.isNotEmpty()) {
            temp.next = ListNode(ascendingList.poll())
            temp = temp.next!!
        }
        return root.next
    }
}
