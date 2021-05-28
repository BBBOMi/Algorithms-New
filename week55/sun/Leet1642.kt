package me.algo.week55.sun

import java.util.*

/**
 * Created by Bomi on 2021/05/28.
 * 문제 출처 : https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue), Array
 */

class Leet1642 {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val diffQueue = PriorityQueue<Int>()
        var bricksCount = bricks
        (0 until heights.lastIndex).forEach {
            val diff = heights[it + 1] - heights[it]
            if (diff <= 0) return@forEach

            diffQueue.offer(diff)
            if (diffQueue.size > ladders) bricksCount -= diffQueue.poll()
            if (bricksCount < 0) return it
        }
        return heights.lastIndex
    }
}