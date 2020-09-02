package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/09/02.
 * 문제 출처 : https://leetcode.com/problems/number-of-islands/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_200 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int h, w;

    private static char[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;

        h = grid.length;
        w = grid[0].length;
        map = grid;

        int count = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] == '1') {
                    count++;
                    bfs(new Point(i, j));
                }
            }
        }

        return count;
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        map[start.x][start.y] = '0';
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i=0; i<4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w)
                    continue;
                if(map[nextX][nextY] == '0')
                    continue;

                queue.offer(new Point(nextX, nextY));
                map[nextX][nextY] = '0';
            }
        }
    }

}
