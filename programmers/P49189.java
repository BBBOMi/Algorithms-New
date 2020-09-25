package me.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49189
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class P49189 {
    public int solution(int n, int[][] edge) {
        boolean[][] vertexes = new boolean[n + 1][n + 1];
        for (int i = 0; i < edge.length; i++) {
            vertexes[edge[i][0]][edge[i][1]] = vertexes[edge[i][1]][edge[i][0]] = true;
        }

        int[] distances = countFarNodes(vertexes, 1);
        Arrays.sort(distances);
        int max = distances[n];
        int answer = 1;
        for(int i=n-1; i>1; i--) {
            if(max > distances[i]) break;
            answer++;
        }
        return answer;
    }

    private static int[] countFarNodes(boolean[][] vertexes, int start) {
        int[] distances = new int[vertexes.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            for(int i=2; i<vertexes.length; i++) {
                if(distances[i] == 0 && vertexes[start][i]) {
                    distances[i] = distances[start] + 1;
                    queue.offer(i);
                }
            }
        }
        return distances;
    }
}
