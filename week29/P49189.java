package me.algo.week29;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/12/04.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49189
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class P49189 {
    public int solution(int n, int[][] edge) {
        boolean[][] map = new boolean[n + 1][n + 1];
        Arrays.stream(edge)
                .forEach((int[] e) -> map[e[0]][e[1]] = map[e[1]][e[0]] = true);

        int[] distance = new int[n + 1];
        bfs(n, map, distance, 1);

        final int maxValue = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance).filter(d -> d == maxValue).count();
    }

    private void bfs(int n, boolean[][] map, int[] distance, int start) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(start);
        distance[start] = 0;

        while (!nodes.isEmpty()) {
            int current = nodes.poll();

            for (int i = 2; i <= n; i++) {
                if (map[current][i] && distance[i] == 0) {
                    nodes.offer(i);
                    distance[i] = distance[current] + 1;
                }
            }
        }
    }
}
