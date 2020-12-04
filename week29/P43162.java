package me.algo.week29;

/**
 * Created by Bomi on 2020/12/04.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43162
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class P43162 {
    private static final int CONNECTION = 1;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] != CONNECTION) continue;
                findConnection(n, computers, j);
                answer++;
            }
        }
        return answer;
    }

    private void findConnection(int n, int[][] computers, int start) {
        for (int i = 0; i < n; i++) {
            if (computers[start][i] != CONNECTION) continue;
            computers[start][i] = 0;
            findConnection(n, computers, i);
        }
    }
}
