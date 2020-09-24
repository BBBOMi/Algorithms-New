package me.algo.week19;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Bomi on 2020/09/24.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42861
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Kruskal
 * Used Data structure : Array
 */

public class P42861 {
    private static int[] root;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt((int[] cost) -> cost[2]));

        root = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            if(findRoot(costs[i][0]) == findRoot(costs[i][1])) continue;
            union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
        }
        return answer;
    }

    private int findRoot(int v) {
        if(root[v] == v) return v;
        return root[v] = findRoot(root[v]);
    }

    private void union(int a, int b) {
        if(root[a] > root[b]) root[root[a]] = root[b];
        else root[root[b]] = root[a];
    }
}
