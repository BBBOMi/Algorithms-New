package me.algo


/**
 * Created by Bomi on 2021/06/17.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/67258
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Map(LinkedHashMap), Array
 */

class P67258 {
    fun solution(gems: Array<String>): IntArray {
        var from = 1
        var to = gems.size
        val gemsCount = gems.distinct().size

        gems.foldIndexed(mutableMapOf<String, Int>()) { index, indexMap, it ->
            indexMap.remove(it)
            indexMap[it] = index

            if (indexMap.size == gemsCount) {
                val tempFrom = indexMap.values.first()
                val tempTo = indexMap.values.last()
                if (tempTo - tempFrom < to - from) {
                    from = tempFrom + 1
                    to = tempTo + 1
                }
            }
            indexMap
        }
        return intArrayOf(from, to)
    }
}