package me.algo.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bomi on 2020/12/09.
 * 문제 출처 : https://www.acmicpc.net/problem/1138
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            int left = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if(left == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                }
                if(result[j] == 0) left--;
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(i -> sb.append(i).append(" "));
        System.out.println(sb.toString());
    }
}
