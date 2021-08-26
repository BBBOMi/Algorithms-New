package me.algo.week63

import java.util.*

/**
 * Created by Bomi on 2021/08/26.
 * 문제 출처 : https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Heap
 * Used Data structure : PriorityQueue
 */

class Leet295 {
    inner class MedianFinder() {
        /** initialize your data structure here. */
        private val minHeap = PriorityQueue<Int>()
        private val maxHeap = PriorityQueue<Int>(reverseOrder())

        fun addNum(num: Int) {
            maxHeap.offer(num)
            minHeap.offer(maxHeap.poll())
            if (maxHeap.size < minHeap.size) {
                maxHeap.offer(minHeap.poll())
            }
        }

        fun findMedian(): Double {
            return if (minHeap.size == maxHeap.size) (minHeap.peek() + maxHeap.peek()) / 2.0
            else maxHeap.peek().toDouble()
        }
    }
}