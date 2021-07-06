package me.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2021/07/06.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/1844
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Queue(LinkedList), Array
 */

public class P1844 {
    private static class Point {
        int x;
        int y;
        int step;

        Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    private static final int WALL = 0;
    private static final int NO_STEP = -1;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        final int height = maps.length;
        final int width = maps[0].length;
        if (maps[height - 1][width - 1] == WALL) return NO_STEP;

        return bfs(height - 1, width - 1, maps, new boolean[height][width]);
    }

    private int bfs(int goalX, int goalY, int[][] maps, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == goalX && current.y == goalY) return current.step;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX > goalX || nextY < 0 || nextY > goalY) continue;
                if (visited[nextX][nextY] || maps[nextX][nextY] == WALL) continue;
                queue.offer(new Point(nextX, nextY, current.step + 1));
                visited[nextX][nextY] = true;
            }
        }
        return NO_STEP;
    }
}
