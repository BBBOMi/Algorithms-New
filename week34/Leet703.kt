package me.algo.week34

import java.util.*

/**
 * Created by Bomi on 2021/01/09.
 * 문제 출처 : https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue)
 */

class Leet703 {

}

class KthLargest(k: Int, nums: IntArray) {
    private val heap = PriorityQueue<Int>(nums.toList())
    private val index = k

    fun add(`val`: Int): Int {
        heap.offer(`val`)
        while (heap.size > index) heap.poll()
        return heap.peek()
    }
}
