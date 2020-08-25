package me.algo.week14;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/1946
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ranks = new int[n + 1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[parseInt(st.nextToken())] = parseInt(st.nextToken());
            }

            int index = 1, count = 1;
            for (int i = 2; i <= n; i++) {
                if (ranks[index] < ranks[i])
                    continue;
                index = i;
                count++;
            }
            bw.write(count + "\n");
        }
        bw.close();
    }
}
