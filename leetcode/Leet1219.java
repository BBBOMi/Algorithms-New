package me.algo.leetcode;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://leetcode.com/problems/path-with-maximum-gold/
 *
 * Time Complexity : O(3^N)
 * Used Algorithm : Backtracking
 * Used Data structure : Array
 */

public class Leet1219 {
    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                int value = getMaximumGold(i, j, grid);
                result = Math.max(value, result);
            }
        }
        return result;
    }

    private int getMaximumGold(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] == 0) return 0;

        int origin = grid[x][y];
        grid[x][y] = 0;
        int maxGold = Math.max(
                Math.max(getMaximumGold(x - 1, y, grid), getMaximumGold(x + 1, y, grid))
                , Math.max(getMaximumGold(x, y - 1, grid), getMaximumGold(x, y + 1, grid)));

        grid[x][y] = origin;
        return origin + maxGold;
    }
}
