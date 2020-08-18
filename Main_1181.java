package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://www.acmicpc.net/problem/1181
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        for(int i=0; i<n; i++) {
            strs[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(strs)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.comparingInt(String::length))
                .forEach(s -> sb.append(s + "\n"));

        System.out.println(sb.toString());
    }
}
