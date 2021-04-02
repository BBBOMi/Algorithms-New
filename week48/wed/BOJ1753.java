package me.algo.week48.wed;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/04/02.
 * 문제 출처 : https://www.acmicpc.net/problem/1753
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Dijkstra
 * Used Data structure : Array, List(ArrayList), Queue(PriorityQueue)
 */

public class BOJ1753 {
    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static final int INF = 300000 * 10 + 1;

    private static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new List[vertexCount + 1];
        while (edgeCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (graph[from] == null) graph[from] = new ArrayList<>();
            graph[from].add(new Edge(to, weight));
        }

        dijkstra(graph, start);
        print();
    }

    private static void dijkstra(List<Edge>[] graph, int start) {
        distances = IntStream.generate(() -> INF).limit(graph.length).toArray();
        distances[start] = 0;

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.weight));
        queue.offer(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (distances[current.to] < current.weight) continue;
            if (graph[current.to] == null) continue;

            for (Edge next : graph[current.to]) {
                if (distances[next.to] <= current.weight + next.weight) continue;
                distances[next.to] = current.weight + next.weight;
                queue.offer(new Edge(next.to, distances[next.to]));
            }
        }
    }

    private static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] == INF) bw.write("INF" + "\n");
            else bw.write(distances[i] + "\n");
        }
        bw.close();
    }
}
