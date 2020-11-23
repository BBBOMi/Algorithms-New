package me.algo.week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/11/23.
 * 문제 출처 : https://www.acmicpc.net/problem/16395
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int k = Integer.parseInt(numbers[1]);

        System.out.println(getKthNumber(n, k));
    }

    private static int getKthNumber(int n, int k) {
        int[][] arr = new int[n + 1][n + 1];
        arr[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int minWidth = Math.min(i, k);
            for (int j = 1; j <= minWidth; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        return arr[n][k];
    }

}
