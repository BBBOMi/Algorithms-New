package me.algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2021/06/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/62050
 *
 * Time Complexity : O(N * log N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class P62050 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Point {
        int x;
        int y;
        int diff;

        Point(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }

    public int solution(int[][] land, int height) {
        final int LENGTH = land.length;
        boolean[][] visited = new boolean[LENGTH][LENGTH];
        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt((Point p) -> p.diff));
        queue.offer(new Point(0, 0, 0));

        int cost = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;

            if (current.diff > height) cost += current.diff;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= LENGTH || nextY < 0 || nextY >= LENGTH) continue;

                queue.offer(new Point(nextX, nextY, absoluteDiff(land[current.x][current.y], land[nextX][nextY])));
            }
        }
        return cost;
    }

    private int absoluteDiff(int a, int b) {
        return Math.abs(a - b);
    }
}
