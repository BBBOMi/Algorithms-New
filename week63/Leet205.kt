package me.algo.week63

/**
 * Created by Bomi on 2021/08/23.
 * 문제 출처 : https://leetcode.com/problems/isomorphic-strings/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

class Leet205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        return if (s.length != t.length) false
        else {
            val sMap = HashMap<Char, Char>()
            val tMap = HashMap<Char, Char>()

            val length = s.length
            (0 until length).forEach { index ->
                sMap.computeIfAbsent(s[index]) { t[index] }
                tMap.computeIfAbsent(t[index]) { s[index] }

                if (sMap[s[index]] != t[index] || tMap[t[index]] != s[index]) {
                    return false
                }
            }
            true
        }
    }
}