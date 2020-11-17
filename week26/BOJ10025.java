package me.algo.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/11/17.
 * 문제 출처 : https://www.acmicpc.net/problem/10025
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sliding-Window
 * Used Data structure : Array
 */

public class BOJ10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());

        // {얼음 양, 양동이 좌표}
        int[][] data = new int[2][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[0][i] = parseInt(st.nextToken());
            data[1][i] = parseInt(st.nextToken());
        }

        System.out.println(maxIceSum(n, k, data));
    }

    private static int maxIceSum(int n, int k, int[][] iceBuckets) {
        final int MAX_INDEX = Arrays.stream(iceBuckets[1]).max().getAsInt();
        int[] ice = new int[MAX_INDEX + 1];
        for(int i=0; i<n; i++) {
            ice[iceBuckets[1][i]] = iceBuckets[0][i];
        }

        final int RANGE = k * 2 + 1;
        int sum = 0, maxSum = 0;
        int fromIndex = 0, currentRange = 0;
        for (int i = 0; i <= MAX_INDEX; i++) {
            if (currentRange >= RANGE) {
                sum -= ice[fromIndex++];
                currentRange--;
            }
            currentRange++;
            sum += ice[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
