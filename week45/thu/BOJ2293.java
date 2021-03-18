package me.algo.week45.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/16.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> coins = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            coins.offer(Integer.parseInt(br.readLine()));
        }
        System.out.println(caseCount(coins, k));
    }

    private static int caseCount(Queue<Integer> coins, int k) {
        int[] counts = new int[k + 1];
        counts[0] = 1;

        while (!coins.isEmpty()) {
            int current = coins.poll();
            for (int i = 1; i <= k; i++) {
                if (i >= current) {
                    counts[i] += counts[i - current];
                }
            }
        }
        return counts[k];
    }
}
