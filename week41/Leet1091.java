package me.algo.week41;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * Created by Bomi on 2021/02/27.
 * 문제 출처 : https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Queue(LinkedList), Array
 */

public class Leet1091 {

    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static final int NO_PATH = -1;

    static class Point {
        int x;
        int y;
        int step;

        Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        Predicate<Integer> isOne = (num) -> num == 1;
        final int LENGTH = grid.length;
        if (isOne.test(grid[0][0]) || isOne.test(grid[LENGTH - 1][LENGTH - 1])) return NO_PATH;

        boolean[][] visited = new boolean[LENGTH][LENGTH];
        Queue<Point> points = new LinkedList();
        points.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!points.isEmpty()) {
            Point current = points.poll();

            if (current.x == LENGTH - 1 && current.y == LENGTH - 1) return current.step;

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= LENGTH || nextY < 0 || nextY >= LENGTH) continue;
                if (grid[nextX][nextY] != 0) continue;
                if (visited[nextX][nextY]) continue;

                points.offer(new Point(nextX, nextY, current.step + 1));
                visited[nextX][nextY] = true;
            }
        }
        return NO_PATH;
    }
}
