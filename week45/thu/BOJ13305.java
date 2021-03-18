package me.algo.week45.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/16.
 * 문제 출처 : https://www.acmicpc.net/problem/13305
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class BOJ13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distances = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minCost(n, distances, costs));
    }

    private static BigInteger minCost(int n, int[] distances, int[] costs) {
        int minCost = Integer.MAX_VALUE;
        BigInteger costSum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, costs[i]);
            BigInteger distanceCost = toBigInteger(minCost).multiply(toBigInteger(distances[i]));
            costSum = costSum.add(distanceCost);
        }
        return costSum;
    }

    private static BigInteger toBigInteger(int n) {
        return new BigInteger(String.valueOf(n));
    }
}
