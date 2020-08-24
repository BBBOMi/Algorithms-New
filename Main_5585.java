package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/24.
 * 문제 출처 : https://www.acmicpc.net/problem/5585
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_5585 {
    private static final int THOUSAND_YEN = 1000;
    private static final int[] YENS = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = THOUSAND_YEN - Integer.parseInt(br.readLine());

        int index = 0,count = 0;
        while(change > 0 && index < YENS.length) {
            count += change/YENS[index];
            change %= YENS[index];
            index++;
        }
        System.out.println(count);
    }
}
