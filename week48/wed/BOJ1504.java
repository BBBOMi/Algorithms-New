package me.algo.week48.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/04/06.
 * 문제 출처 : https://www.acmicpc.net/problem/1504
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Dijkstra
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class BOJ1504 {
    private static final int INFINITY = 200000 * 1000;

    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][n + 1];
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[a][b] = matrix[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(minDistance(1, n, v1, v2));
    }

    private static int minDistance(int from, int to, int mustPassed1, int mustPassed2) {
        final int NO_ROUTE = -1;
        int distance1 = dijkstra(from, mustPassed1) + dijkstra(mustPassed1, mustPassed2) + dijkstra(mustPassed2, to);
        int distance2 = dijkstra(from, mustPassed2) + dijkstra(mustPassed2, mustPassed1) + dijkstra(mustPassed1, to);
        return (distance1 >= INFINITY && distance2 >= INFINITY) ? NO_ROUTE : Math.min(distance1, distance2);
    }

    private static int dijkstra(int from, int to) {
        final int LENGTH = matrix.length;
        boolean[] visited = new boolean[LENGTH];
        int[] distances = IntStream.range(0, LENGTH).map(it -> INFINITY).toArray();

        Queue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt((int[] a) -> a[1]))); // (next, weight)
        queue.offer(new int[]{from, 0});
        distances[from] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentFrom = current[0];
            int weight = current[1];
            if (visited[currentFrom]) continue;
            visited[currentFrom] = true;

            for (int i = 1; i < LENGTH; i++) {
                if (visited[i] || matrix[currentFrom][i] == 0) continue;
                if (distances[i] < weight + matrix[currentFrom][i]) continue;
                distances[i] = weight + matrix[currentFrom][i];
                queue.offer(new int[]{i, distances[i]});
            }
        }
        return distances[to];
    }
}
