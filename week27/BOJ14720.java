package me.algo.week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/11/23.
 * 문제 출처 : https://www.acmicpc.net/problem/14720
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class BOJ14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] milk = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            milk[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(countMilk(n, milk));
    }

    private static int countMilk(int n, int[] milk) {
        final int COUNT_OF_TYPE = 3;
        boolean start = false;
        int lastMilk = 0, count = 0;

        for (int m : milk) {
            if (!start && m == 0) {
                start = true;
                count++;
                continue;
            }
            if (start && m == ((lastMilk + 1) % COUNT_OF_TYPE)) {
                count++;
                lastMilk = ++lastMilk % COUNT_OF_TYPE;
            }
        }
        return count;
    }
}
