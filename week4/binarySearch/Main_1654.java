package me.algo.week4.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/16.
 * 문제 출처 : https://www.acmicpc.net/problem/1654
 *
 * Time Complexity : O(logN)
 * Used Algorithm : binary search
 * Used Data structure : Arrays
 */

public class Main_1654 {
    private static int[] lans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        lans = new int[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lans);
        System.out.println(calculateMaxLength(n, lans[k-1]));
    }

    private static long calculateMaxLength(int n, int max) {
        long low = 1, high = max;
        long maxLength = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isAbleToMakeLonger(mid, n)) {
                maxLength = mid;
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return maxLength;
    }

    private static boolean isAbleToMakeLonger(long high, int n) {
        int count = 0;
        for (int i = 0,len=lans.length; i < len; i++) {
           count += lans[i] / high;
        }
        return count >= n;
    }
}
