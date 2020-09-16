package me.algo.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/09/16.
 * 문제 출처 : https://www.acmicpc.net/problem/1922
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Kruskal
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class Main_1922 {
    static class Edge {
        int from;
        int to;
        int value;

        Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    private static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int m = parseInt(br.readLine());

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.value));
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            queue.offer(new Edge(from, to, value));
        }

        root = new int[n+1];
        for(int i=1; i<=n; i++) {
            root[i] = i;
        }
        System.out.println(kruskal(queue));
    }

    private static int kruskal(Queue<Edge> queue) {
        int sum = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            if(find(current.from) == find(current.to)) continue;
            union(current.from, current.to);
            sum += current.value;
        }
        return sum;
    }

    // 경로 압축(Path Compression)
    // find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
    // O(log N)
    private static int find(int vertex) {
        if(root[vertex] == vertex) return vertex;
        return root[vertex] = find(root[vertex]);
    }

    private static void union(int a, int b) {
        if(root[a] > root[b]) root[root[a]] = root[b];
        else root[root[b]] = root[a];
    }
}
