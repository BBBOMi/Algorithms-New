package me.algo.week86

/**
 * Created by Bomi on 2022/04/16.
 * 문제 출처 : https://leetcode.com/problems/sentence-similarity-iii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Deque
 */

class Leet1813 {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val sentence1Deq = sentence1.toDeque()
        val sentence2Deq = sentence2.toDeque()

        val longDeq = if (sentence1Deq.size > sentence2Deq.size) sentence1Deq else sentence2Deq
        val shortDeq = if (longDeq == sentence1Deq) sentence2Deq else sentence1Deq

        while (shortDeq.isNotEmpty()) {
            if (longDeq.first() == shortDeq.first()) {
                longDeq.removeFirst()
                shortDeq.removeFirst()
            } else {
                if (longDeq.last() != shortDeq.last()) return false
                longDeq.removeLast()
                shortDeq.removeLast()
            }
        }
        return true
    }

    private fun String.toDeque() = this.split(" ").toCollection(ArrayDeque<String>())
}
