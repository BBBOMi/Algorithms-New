package me.algo.week66

import java.util.*

/**
 * Created by Bomi on 2021/09/20.
 * 문제 출처 : https://leetcode.com/problems/design-hashset/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, LinkedList
 */

class Leet705 {
    private class MyHashSet() {

        /** Initialize your data structure here. */
        val arraySize = 100_000
        val mySet = Array<LinkedList<Int>>(arraySize) { LinkedList() }

        fun add(key: Int) {
            val index = findIndex(key)
            mySet[index].find { it == key }?.let { return }
            mySet[index].add(key)
        }

        fun remove(key: Int) {
            val index = findIndex(key)
            mySet[index].removeIf { it == key }
        }

        /** Returns true if this set contains the specified element */
        fun contains(key: Int): Boolean {
            val index = findIndex(key)
            return mySet[index].find { it == key } != null
        }

        private fun findIndex(num: Int) = num.rem(arraySize)
    }
}