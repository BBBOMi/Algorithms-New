package me.algo.week49.sun

/**
 * Created by Bomi on 2021/04/21.
 * 문제 출처 : https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Array, List(ArrayList)
 */

class Leet417 {
    private var height = 0
    private var width = 0

    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        height = heights.size
        width = heights[0].size

        val pacificRoute = Array(height) { BooleanArray(width) }
        val atlanticRoute = Array(height) { BooleanArray(width) }

        for (i in 0 until height) {
            dfs(heights, pacificRoute, Int.MIN_VALUE, i, 0)
            dfs(heights, atlanticRoute, Int.MIN_VALUE, i, width - 1)
        }

        for (i in 0 until width) {
            dfs(heights, pacificRoute, Int.MIN_VALUE, 0, i)
            dfs(heights, atlanticRoute, Int.MIN_VALUE, height - 1, i)
        }

        val answer = mutableListOf<List<Int>>()
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (pacificRoute[i][j] && atlanticRoute[i][j]) {
                    answer.add(listOf(i, j))
                }
            }
        }
        return answer
    }

    private fun dfs(heights: Array<IntArray>, visited: Array<BooleanArray>, preHeight: Int, currentX: Int, currentY: Int) {
        if (currentX < 0 || currentX >= height || currentY < 0 || currentY >= width) return
        if (visited[currentX][currentY] || heights[currentX][currentY] < preHeight) return

        visited[currentX][currentY] = true
        for (i in 0 until dx.size) {
            dfs(heights, visited, preHeight, currentX + dx[i], currentY + dy[i])
        }
    }
}