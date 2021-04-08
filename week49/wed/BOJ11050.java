package me.algo.week49.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/08.
 * 문제 출처 : https://www.acmicpc.net/problem/11050
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] factorials = new int[n + 1];
        fillFactorials(factorials);

        System.out.println(factorials[n] / (factorials[n - k] * factorials[k]));
    }

    private static void fillFactorials(int[] factorials) {
        int n = factorials.length;
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
    }
}
