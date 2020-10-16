package me.algo.week22;

import java.util.*;

/**
 * Created by Bomi on 2020/10/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42861
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Kruskal
 * Used Data structure : Array
 */

public class P42861 {
    private static int[] root;

    public int solution(int n, int[][] costs) {
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }

        int sum = 0;
        Arrays.sort(costs, Comparator.comparingInt((int[] arr) -> arr[2]));
        for (int[] current : costs) {
            if (findRoot(current[0]) == findRoot(current[1])) continue;
            union(current[0], current[1]);
            sum += current[2];
        }
        return sum;
    }

    private int findRoot(int v) {
        if (root[v] == v) return v;
        return root[v] = findRoot(root[v]);
    }

    private void union(int a, int b) {
        if (root[a] > root[b]) root[root[a]] = root[b];
        else root[root[b]] = root[a];
    }
}
