package me.algo.week60

import kotlin.math.max

/**
 * Created by Bomi on 2021/07/12.
 * 문제 출처 : https://leetcode.com/problems/max-area-of-island/
 *
 * Time Complexity : O(N * M)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

class Leet695 {
    private val NOT_ISLAND = 0
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var answer = 0
        (grid.indices).forEach { x ->
            (grid.first().indices).forEach inner@{ y ->
                if (grid[x][y] == NOT_ISLAND) return@inner
                answer = max(answer, areaOfIsland(x, y, grid))
            }
        }
        return answer
    }

    private fun areaOfIsland(currentX: Int, currentY: Int, grid: Array<IntArray>): Int {
        return if (currentX < 0 || currentX >= grid.size || currentY < 0 || currentY >= grid.first().size) 0
        else if (grid[currentX][currentY] == NOT_ISLAND) 0
        else {
            grid[currentX][currentY] = NOT_ISLAND

            1 + areaOfIsland(currentX - 1, currentY, grid) +
                    areaOfIsland(currentX + 1, currentY, grid) +
                    areaOfIsland(currentX, currentY - 1, grid) +
                    areaOfIsland(currentX, currentY + 1, grid)
        }
    }
}