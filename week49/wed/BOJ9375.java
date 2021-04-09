package me.algo.week49.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bomi on 2021/04/09.
 * 문제 출처 : https://www.acmicpc.net/problem/9375
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

public class BOJ9375 {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solution(n)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int solution(int n) throws IOException {
        Map<String, Integer> comb = new HashMap<>();
        while (n-- > 0) {
            String[] cloth = br.readLine().split(" ");
            comb.put(cloth[1], comb.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (int value : comb.values()) {
            answer *= value + 1;
        }
        return --answer;
    }
}
