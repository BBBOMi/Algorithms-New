package me.algo.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/11/29.
 * 문제 출처 : https://www.acmicpc.net/problem/1753
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Dijkstra
 * Used Data structure : Queue(PriorityQueue), List(ArrayList), Array
 */

public class BOJ1753 {
    static class Edge {
        int to;
        int distance;

        Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    private static List<Edge>[] vertexes;
    private static int[] distances;

    private static final int INFINITY = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexCount = parseInt(st.nextToken());
        int edgeCount = parseInt(st.nextToken());
        int start = parseInt(br.readLine());

        vertexes = new List[vertexCount + 1];
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = parseInt(st.nextToken());
            int v = parseInt(st.nextToken());
            int w = parseInt(st.nextToken());

            if (vertexes[u] == null) vertexes[u] = new ArrayList();
            vertexes[u].add(new Edge(v, w));
        }

        distances = IntStream.generate(() -> INFINITY)
                .limit(vertexCount + 1).toArray();

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertexCount; i++) {
            if (distances[i] == INFINITY) sb.append("INF");
            else sb.append(distances[i]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        distances[start] = 0;

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.distance));
        queue.offer(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (distances[current.to] < current.distance) continue;
            if (vertexes[current.to] == null) continue;
            for (int i = 0; i < vertexes[current.to].size(); i++) {
                Edge next = vertexes[current.to].get(i);
                int nextVertex = next.to;
                int nextDistance = current.distance + next.distance;

                if (nextDistance < distances[nextVertex]) {
                    distances[nextVertex] = nextDistance;
                    queue.offer(new Edge(nextVertex, nextDistance));
                }
            }
        }
    }
}
