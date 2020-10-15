package me.algo.week22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/10/15.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49189
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class P49189 {
    public int solution(int n, int[][] edge) {
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] e : edge) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = true;
        }

        int[] distances = new int[n + 1];
        countDistance(1, map, distances);

        int max = Arrays.stream(distances).max().getAsInt();
        return (int) Arrays.stream(distances).filter(d -> d == max).count();
    }

    private void countDistance(int start, boolean[][] map, int[] distances) {
        Queue<Integer> indexes = new LinkedList<>();
        indexes.offer(start);
        while (!indexes.isEmpty()) {
            int current = indexes.poll();
            for (int i = 2; i < map.length; i++) {
                if (map[current][i] && distances[i] == 0) {
                    distances[i] = distances[current] + 1;
                    indexes.offer(i);
                }
            }
        }
    }
}
