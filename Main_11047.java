package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/26.
 * 문제 출처 : https://www.acmicpc.net/problem/11047
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] money = new long[n];
        for(int i=0; i<n; i++) {
            money[i] = Long.parseLong(br.readLine());
        }

        int sum = 0;
        long[] quotient = new long[n];
        for(int i=n-1; i>=0; i--) {
            quotient[i] = k / money[i];
            k %= money[i];
            sum += quotient[i];
        }

        System.out.println(sum);

    }
}
