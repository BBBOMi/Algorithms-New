package me.algo.week28;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Predicate;

/**
 * Created by Bomi on 2020/11/30.
 * 문제 출처 : https://www.acmicpc.net/problem/4485
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Dijkstra
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class BOJ4485 {
    static class Point {
        int x;
        int y;
        int weight;

        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int playCount = 0;
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            playCount++;

            int[][] map = new int[n][n];
            int[][] weights = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    weights[i][j] = Integer.MAX_VALUE;
                }
            }
            bw.write(String.format("Problem %d: %d \n", playCount, dijkstra(n, map, weights)));
        }
        bw.close();
    }

    private static int dijkstra(int n, int[][] map, int[][] weights) {
        Queue<Point> pointQueue = new PriorityQueue(Comparator.comparingInt((Point p) -> p.weight));
        weights[0][0] = map[0][0];
        pointQueue.offer(new Point(0, 0, map[0][0]));

        Predicate<Integer> exclusiveOf = (point) -> point < 0 || n <= point;

        while (!pointQueue.isEmpty()) {
            Point current = pointQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (exclusiveOf.test(nextX) || exclusiveOf.test(nextY)) continue;
                if (weights[nextX][nextY] > weights[current.x][current.y] + map[nextX][nextY]) {
                    weights[nextX][nextY] = weights[current.x][current.y] + map[nextX][nextY];
                    pointQueue.offer(new Point(nextX, nextY, weights[nextX][nextY]));
                }
            }
        }
        return weights[n - 1][n - 1];
    }
}
