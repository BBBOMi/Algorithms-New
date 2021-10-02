package me.algo.week67

/**
 * Created by Bomi on 2021/10/03.
 * 문제 출처 : https://leetcode.com/problems/rotting-oranges/
 *
 * Time Complexity : O(C * M * N)
 * Used Algorithm : BFS
 * Used Data structure : Array
 */

class Leet994 {
    private val freshOrange = 1
    private val rottenOrange = 2

    fun orangesRotting(grid: Array<IntArray>): Int {
        var minutes = 0
        var totalFreshOranges = grid.map { row -> row.count { it == freshOrange } }.sum()
        var remainFreshOranges = totalFreshOranges

        while (totalFreshOranges > 0) {
            for (i in grid.indices) {
                for (j in 0 until grid[i].size) {
                    if (grid[i][j] != rottenOrange + minutes) continue
                    totalFreshOranges -= countRotting(grid, i + 1, j, minutes) +
                            countRotting(grid, i - 1, j, minutes) +
                            countRotting(grid, i, j + 1, minutes) +
                            countRotting(grid, i, j - 1, minutes)
                }
            }

            if (totalFreshOranges == remainFreshOranges) return -1

            minutes++
            remainFreshOranges = totalFreshOranges
        }
        return minutes
    }

    private fun countRotting(grid: Array<IntArray>, i: Int, j: Int, minutes: Int): Int {
        return when {
            i < 0 || j < 0 || i >= grid.size || j >= grid[i].size -> 0
            grid[i][j] != freshOrange -> 0
            else -> {
                grid[i][j] += minutes + rottenOrange
                1
            }
        }
    }

}