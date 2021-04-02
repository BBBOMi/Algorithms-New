package me.algo.week48.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/02.
 * 문제 출처 : https://www.acmicpc.net/problem/1037
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        System.out.println(min * max);
    }
}
