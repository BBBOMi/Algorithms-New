package me.algo.week15;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/09/01.
 * 문제 출처 : https://www.acmicpc.net/problem/1753
 *
 * Time Complexity : O(N * logN)
 * Used Algorithm : Dijkstra
 * Used Data structure : Queue(PriorityQueue), List(ArrayList), Array
 */

public class Main_1753 {
    static class Pair {
        int to;
        int distance;

        Pair(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    private static List<Pair>[] vertex;
    private static int[] distance;

    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        vertex = new List[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (vertex[u] == null) vertex[u] = new ArrayList<>();
            vertex[u].add(new Pair(v, w));
        }

        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        distance[start] = 0;

        Queue<Pair> queue = new PriorityQueue<Pair>((Comparator.comparingInt((Pair p) -> p.distance)));
        queue.offer(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            if (distance[current.to] < current.distance) continue;
            if (vertex[current.to] == null) continue;

            for (int i = 0; i < vertex[current.to].size(); i++) {
                Pair next = vertex[current.to].get(i);
                int nextDistance = current.distance + next.distance;

                if (nextDistance < distance[next.to]) {
                    distance[next.to] = nextDistance;
                    queue.offer(new Pair(next.to, nextDistance));
                }
            }
        }
    }
}
