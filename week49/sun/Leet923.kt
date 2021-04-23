package me.algo.week49.sun

/**
 * Created by Bomi on 2021/04/23.
 * 문제 출처 : https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Hash
 * Used Data structure : Map(LinkedHashMap), Array
 */

class Leet923 {
    private val MOD = 1000_000_000 + 7

    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val countMap = mutableMapOf<Int, Int>()

        var count = 0
        arr.forEachIndexed { index, item ->
            count = (count + countMap.getOrDefault(target - item, 0)) % MOD

            for (i in 0 until index) {
                val sum = item + arr[i]
                countMap[sum] = countMap.getOrDefault(sum, 0) + 1
            }
        }
        return count
    }
}