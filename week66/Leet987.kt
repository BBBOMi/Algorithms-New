package me.algo.week66

/**
 * Created by Bomi on 2021/09/25.
 * 문제 출처 : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : DFS
 * Used Data structure : Tree, HashMap, List
 */

class Leet987 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val values = HashMap<Int, MutableList<Pair<Int, Int>>>() // <column, <depth, value>>
        dfs(root, 0, 0, values)
        return values.toSortedMap()
                .values
                .map { it.sortedWith(compareBy({ p -> p.first }, { p -> p.second })) }
                .map { it.map { p -> p.second } }
    }

    private fun dfs(current: TreeNode?, depth: Int, column: Int, values: HashMap<Int, MutableList<Pair<Int, Int>>>) {
        current?.let {
            values.computeIfAbsent(column) { arrayListOf() }.add(depth to current.`val`)
            dfs(current.left, depth + 1, column - 1, values)
            dfs(current.right, depth + 1, column + 1, values)
        }
    }
}