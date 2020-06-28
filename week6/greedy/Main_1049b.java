package me.algo.week6.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/28.
 * 문제 출처 : https://www.acmicpc.net/problem/1049
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_1049b {
    private static final int PACKAGE = 6;
    private static int[] packages;
    private static int[] singles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        packages = new int[m];
        singles = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            singles[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packages);
        Arrays.sort(singles);

        System.out.println(calculateTheMinimumMoney(n));

    }

    private static int calculateTheMinimumMoney(int wantedCount) {
        int maxFee = 100 * 1000;
        int packageCount = wantedCount / PACKAGE;
        if(packageCount == 0)
            packageCount++;

        int a = singles[0] * wantedCount;
        int b = packages[0] * packageCount;
        int c = b + (wantedCount % PACKAGE) * singles[0];
        if(wantedCount % PACKAGE != 0)
            b += packages[0];

        return min(maxFee, min(a, b, c));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static int min(int a, int b, int c) {
        if(min(a, b) == a) return min(a, c);
        return min(b, c);
    }
}
