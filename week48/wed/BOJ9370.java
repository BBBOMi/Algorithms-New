package me.algo.week48.wed;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/04/06.
 * 문제 출처 : https://www.acmicpc.net/problem/9370
 *
 * Time Complexity : O(N * N log N)
 * Used Algorithm : Dijkstra
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class BOJ9370 {
    private static class Edge {
        int to;
        int distance;

        Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    private static int[][] matrix;
    private static final int INFINITY = 50000 * 1000;
    private static int vertexCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            int candidateCount = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            matrix = new int[vertexCount + 1][vertexCount + 1];
            while (edgeCount-- > 0) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                matrix[v1][v2] = matrix[v2][v1] = distance * 2;

                if ((v1 == g && v2 == h) || (v1 == h && v2 == g)) {
                    matrix[v1][v2]--;
                    matrix[v2][v1]--;
                }
            }

            Queue<Integer> candidates = new PriorityQueue<>();
            while (candidateCount-- > 0) {
                candidates.add(Integer.parseInt(br.readLine()));
            }

            bw.write(solution(start, candidates) + "\n");
        }
        bw.close();
    }

    private static String solution(int start, Queue<Integer> candidates) {
        StringBuilder sb = new StringBuilder();
        while (!candidates.isEmpty()) {
            int end = candidates.poll();

            int minDistance = dijkstra(start, end);
            if (minDistance % 2 != 0) sb.append(end).append(" ");
        }

        return sb.toString();
    }

    private static int dijkstra(int from, int to) {
        boolean[] visited = new boolean[vertexCount + 1];
        int[] distances = IntStream.rangeClosed(0, vertexCount).map(it -> INFINITY).toArray();
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.distance));

        edges.offer(new Edge(from, 0));
        distances[from] = 0;

        while (!edges.isEmpty()) {
            Edge current = edges.poll();
            if (visited[current.to]) continue;
            visited[current.to] = true;

            for (int i = 1; i <= vertexCount; i++) {
                if (visited[i] || matrix[current.to][i] == 0) continue;
                if (distances[i] < current.distance + matrix[current.to][i]) continue;
                distances[i] = current.distance + matrix[current.to][i];
                edges.offer(new Edge(i, distances[i]));
            }
        }
        return distances[to];
    }

}
