package me.algo.week49.sun

/**
 * Created by Bomi on 2021/04/20.
 * 문제 출처 : https://leetcode.com/problems/word-subsets/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array, List(ArrayList)
 */
class Leet916 {
    private val ALPHABET_COUNT = 26

    fun wordSubsets(A: Array<String>, B: Array<String>): List<String?> {
        val bMax = IntArray(ALPHABET_COUNT)
        for (b in B) {
            val bCount = count(b)
            for (i in 0 until ALPHABET_COUNT) {
                bMax[i] = bMax[i].coerceAtLeast(bCount[i])
            }
        }

        val answer = mutableListOf<String>()
        A.forEach {
            val aCount = count(it)
            for (i in 0 until ALPHABET_COUNT) {
                if (aCount[i] < bMax[i]) return@forEach
            }
            answer.add(it)
        }

        return answer
    }

    private fun count(S: String): IntArray {
        val counts = IntArray(ALPHABET_COUNT)
        S.toCharArray().forEach {
            counts[it - 'a']++
        }
        return counts
    }
}