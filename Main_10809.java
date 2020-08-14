package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bomi on 2020/08/14.
 * 문제 출처 : https://www.acmicpc.net/problem/10809
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] indexes = new int[26];
        for (int i = 0; i < 26; i++) {
            indexes[i] = s.indexOf((char)(i + 97));
        }
        Arrays.stream(indexes).forEach(i -> System.out.print(i + " "));
    }
}
