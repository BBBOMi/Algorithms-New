package me.algo.week67

/**
 * Created by Bomi on 2021/10/09.
 * 문제 출처 : https://leetcode.com/problems/iterator-for-combination/
 *
 * Time Complexity : O(N^C)
 * Used Algorithm : Backtracking
 * Used Data structure : List
 */

class Leet1286 {
    class CombinationIterator(characters: String, combinationLength: Int) {
        private val list = mutableListOf<String>()
        private val iterator: Iterator<String>

        init {
            val str = characters.toCharArray()
                    .distinct()
                    .sorted()
                    .joinToString("")
                    .toLowerCase()
            combination(str, combinationLength, 0, "")
            iterator = list.iterator()
        }

        fun next() = iterator.next()

        fun hasNext() = iterator.hasNext()

        private fun combination(characters: String, combinationLength: Int, index: Int, currentStr: String) {
            if (currentStr.length == combinationLength) {
                list.add(currentStr)
                return
            }

            for (i in index until characters.length) {
                combination(characters, combinationLength, i + 1, currentStr + characters[i])
            }
        }
    }

}