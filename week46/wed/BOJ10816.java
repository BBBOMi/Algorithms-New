package me.algo.week46.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/18.
 * 문제 출처 : https://www.acmicpc.net/problem/10816
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> countMap = new HashMap<>(); // number, count

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int key = Integer.parseInt(st.nextToken());
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(getCount(countMap, number)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int getCount(Map<Integer, Integer> countMap, int number) {
        return countMap.getOrDefault(number, 0);
    }
}
