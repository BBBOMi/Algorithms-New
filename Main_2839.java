package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/14.
 * 문제 출처 : https://www.acmicpc.net/problem/2839
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math, Implementation
 */

public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countPackages(n));
    }

    private static int countPackages(int n) {
        int sugar = n;
        int count = 0;
        while(sugar >= 0) {
            if (sugar == 0) {
                return count;
            }
            if(sugar % 5 == 0) {
                return (sugar / 5) + count;
            }
            sugar -=3;
            count++;
        }
        return -1;
    }
}
