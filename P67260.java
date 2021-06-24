package me.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Bomi on 2021/06/24.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/67260
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, List(ArrayList), Queue(LinkedList)
 */

public class P67260 {
    private static final int START = 0;

    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] nodes = new List[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] p : path) {
            nodes[p[0]].add(p[1]);
            nodes[p[1]].add(p[0]);
        }

        int[] before = new int[n];
        for (int[] o : order) {
            before[o[1]] = o[0];
        }

        if (before[START] != 0) return false;

        Queue<Integer> queue = new LinkedList<>(nodes[START]);
        boolean[] visited = new boolean[n];
        visited[START] = true;

        int[] waits = new int[n];
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited[current]) continue;
            if (!visited[before[current]]) {
                waits[before[current]] = current;
                continue;
            }

            visited[current] = true;
            nodes[current].forEach(queue::offer);
            queue.offer(waits[current]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
