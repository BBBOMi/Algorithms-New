package me.algo.week55.wed

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Bomi on 2021/05/27.
 * 문제 출처 : https://www.acmicpc.net/problem/14725
 *
 * Time Complexity : O(N)
 * Used Algorithm : Trie, DFS
 * Used Data structure : Trie, List(ArrayList)
 */

private class FoodTrie(val value: String) {
    val child: MutableList<FoodTrie> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        return other.hashCode() == this.hashCode()
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val root = FoodTrie("")
    val n = readLine().toInt()
    repeat(n) {
        val feed = readLine().split(" ")
        insert(root, feed.subList(1, feed.size))
    }

    val result = StringBuilder()
    readToResult(root, 0, result)
    println(result.toString())
}

private fun insert(root: FoodTrie, words: List<String>) {
    var temp = root
    words.forEach { word ->
        val existed = temp.child.find { it == FoodTrie(word) }
        temp = if (existed == null) {
            val newTrie = FoodTrie(word)
            temp.child.add(newTrie)
            newTrie
        } else existed
    }
}

private fun readToResult(root: FoodTrie, depth: Int, sb: StringBuilder) {
    root.child
            .sortedBy { it.value }
            .forEach {
                markDepth(depth, sb)
                sb.append("${it.value} \n")
                readToResult(it, depth + 1, sb)
            }
}

private fun markDepth(depth: Int, sb: StringBuilder) {
    val layeredMark = "--"
    repeat(depth) {
        sb.append(layeredMark)
    }
}