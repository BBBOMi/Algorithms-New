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
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_1049 {
    private static final int PACKAGE = 6;
    private static final int MAX_FEE = 100 * 1000;

    private static int[] packages;
    private static int[] singles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        packages = new int[m + 1];
        singles = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            singles[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packages);
        Arrays.sort(singles);

        System.out.println(calculateTheMinimumMoney(n));
    }

    private static int calculateTheMinimumMoney(int wantedCount) {
        boolean packaging = wantedCount % PACKAGE == 0;
        int packageCount = wantedCount / PACKAGE;
        if(packageCount == 0)
            packageCount++;
        int fee = MAX_FEE;
        int length = packages.length;
        for(int packageIndex = 1; packageIndex<length; packageIndex++) {
             for(int singleIndex = 1; singleIndex<length; singleIndex++) {
                 int singleFee = singles[singleIndex] * wantedCount;
                 int packageFee = packages[packageIndex] * (packageCount);
                 int singlePackageFee = packageFee;
                 if(!packaging) {
                     packageFee += packages[packageIndex];
                     singlePackageFee += (wantedCount % PACKAGE) * singles[singleIndex];
                 }
                 fee = min(fee, min(singleFee, packageFee, singlePackageFee));
             }
        }
        return fee;
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static int min(int a, int b, int c) {
        if(min(a, b) == a) return min(a, c);
        return min(b, c);
    }
}