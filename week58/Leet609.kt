package me.algo.week58

/**
 * Created by Bomi on 2021/06/21.
 * 문제 출처 : https://leetcode.com/problems/find-duplicate-file-in-system/
 *
 * Time Complexity : O(N * M)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap), Array, List(ArrayList)
 */

class Leet609 {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>() // <content, file>
        paths.forEach { path ->
            val directory = path.split(" ")
            val directoryName = directory[0]
            directory.slice(IntRange(1, directory.lastIndex))
                .forEach {
                    val file = it.split("(")
                    val name = file[0]
                    val content = file[1]
                    map.computeIfAbsent(content) { mutableListOf() }.add("$directoryName/$name")
                }
        }
        return map.filter { it.value.size > 1 }.values.toList()
    }
}