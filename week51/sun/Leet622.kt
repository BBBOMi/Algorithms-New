package me.algo.week51.sun

/**
 * Created by Bomi on 2021/04/28.
 * 문제 출처 : https://leetcode.com/problems/design-circular-queue/
 *
 * Time Complexity : O(1)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

class MyCircularQueue(k: Int) {
    private val queue = IntArray(k)
    private var front = 0
    private var rear = -1
    private var size = 0

    fun enQueue(value: Int): Boolean {
        return if (isFull()) false
        else {
            rear = (rear + 1).rem(queue.size)
            queue[rear] = value
            size++
            true
        }
    }

    fun deQueue(): Boolean {
        return if (isEmpty()) false
        else {
            front = (front + 1).rem(queue.size)
            size--
            true
        }
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else queue[front]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else queue[rear]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == queue.size
    }
}