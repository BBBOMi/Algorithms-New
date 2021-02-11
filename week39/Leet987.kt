package me.algo.week39

/**
 * Created by Bomi on 2021/02/11.
 * 문제 출처 : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Map(LinkedHashMap), List(ArrayList), TreeNode
 */

class Leet987 {
    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>() // pair (x, val)
        dfs(root, 0, 0, map)
        return map.toSortedMap().values
                .map { value -> value.sortedWith(compareBy({ it.first }, { it.second })) }
                .map { value -> value.map { it.second } }.toList()
    }

    fun dfs(root: TreeNode?, x: Int, y: Int, map: MutableMap<Int, MutableList<Pair<Int, Int>>>) {
        root?.let {
            map.putIfAbsent(y, mutableListOf())
            map[y]!!.add(Pair(x, root.`val`))

            dfs(root.left, x + 1, y - 1, map)
            dfs(root.right, x + 1, y + 1, map)
        }
    }
}