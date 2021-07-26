package me.algo.week61

import kotlin.math.max

/**
 * Created by Bomi on 2021/07/26.
 * 문제 출처 : https://leetcode.com/problems/max-area-of-island/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

class Leet695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        (grid.indices).forEach row@{ i ->
            (grid[0].indices).forEach column@{ j ->
                if (grid[i][j] != ISLAND) return@column
                val area = dfs(i, j, grid)
                maxArea = max(maxArea, area)
            }
        }
        return maxArea
    }

    private fun dfs(x: Int, y: Int, grid: Array<IntArray>): Int {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size) return 0
        if (grid[x][y] != ISLAND) return 0

        grid[x][y] = WATER
        return 1 + dfs(x - 1, y, grid) +
                dfs(x + 1, y, grid) +
                dfs(x, y - 1, grid) +
                dfs(x, y + 1, grid)
    }

    private companion object {
        private const val WATER = 0
        private const val ISLAND = 1
    }
}