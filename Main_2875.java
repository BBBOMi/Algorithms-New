package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/24.
 * 문제 출처 : https://www.acmicpc.net/problem/2875
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 */

public class Main_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int team = 0;
        while (n >= 2 && m >= 1 && n + m >= k + 3) {
            n -= 2;
            m--;
            team++;
        }
        System.out.println(team);
    }
}
