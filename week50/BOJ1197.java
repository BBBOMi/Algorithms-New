package me.algo.week50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/04/19.
 * 문제 출처 : https://www.acmicpc.net/problem/1197
 *
 * Time Complexity : O(E log V)
 * Used Algorithm : Kruskal
 * Used Data structure : Queue(PriorityQueue), Array
 */

public class BOJ1197 {
    private static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt((Edge edge) -> edge.weight));
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.offer(new Edge(a, b, weight));
        }
        System.out.println(kruskal(v, edges));
    }

    private static int kruskal(int v, Queue<Edge> edges) {
        int sum = 0;
        parent = IntStream.iterate(0, i -> i <= v, i -> i += 1).toArray();

        while (!edges.isEmpty()) {
            Edge current = edges.poll();
            if (find(current.from) == find(current.to)) continue;
            union(current.from, current.to);
            sum += current.weight;
        }
        return sum;
    }

    private static int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    private static void union(int a, int b) {
        parent[parent[a]] = parent[b];
    }
}
