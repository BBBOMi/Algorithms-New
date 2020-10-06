package me.algo.leetcode;


/**
 * Created by Bomi on 2020/10/06.
 * 문제 출처 : https://leetcode.com/problems/max-area-of-island/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Graph(BFS, DFS)
 * Used Data structure : Array, List(ArrayList)
 */

public class Leet695 {
    /* runtime: 3ms / memory: 39.6MB */
//    private static int[] dx = {-1, 1, 0, 0};
//    private static int[] dy = {0, 0, -1, 1};
//
//    public int maxAreaOfIsland(int[][] grid) {
//        int maxCount = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    int count = bfs(i, j, grid);
//                    if (maxCount < count) maxCount = count;
//                }
//            }
//        }
//        return maxCount;
//    }
//
//    private static int bfs(int x, int y, int[][] grid) {
//        List<int[]> islands = new ArrayList<>();
//        islands.add(new int[]{x, y});
//        grid[x][y] = 0;
//        int index = -1;
//        while (++index < islands.size()) {
//            int[] island = islands.get(index);
//            for (int i = 0; i < 4; i++) {
//                int nextX = island[0] + dx[i];
//                int nextY = island[1] + dy[i];
//
//                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
//                if (grid[nextX][nextY] == 0) continue;
//
//                islands.add(new int[]{nextX, nextY});
//                grid[nextX][nextY] = 0;
//            }
//        }
//        return islands.size();
//    }

    /* runtime: 2ms / memory: 39.8MB */
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = area(i, j, grid);
                    if (maxCount < count) maxCount = count;
                }
            }
        }
        return maxCount;
    }

    private int area(int x, int y, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if(grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        return 1 + area(x-1, y, grid) + area(x+1, y, grid)
                + area(x, y-1, grid) + area(x, y+1, grid);
    }
}
