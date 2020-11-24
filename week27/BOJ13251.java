package me.algo.week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

/**
 * Created by Bomi on 2020/11/24.
 * 문제 출처 : https://www.acmicpc.net/problem/13251
 *
 * Time Complexity : O(N)
 * Used Algorithm : Combination
 */

public class BOJ13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(br.readLine());

        int totalCount = 0;
        double totalCombination = 0.0;
        while (st.hasMoreTokens()) {
            int count = Integer.parseInt(st.nextToken());
            totalCount += count;
            totalCombination += combination(count, r);
        }
        System.out.println(totalCombination / combination(totalCount, r));
    }

    private static double combination(int n, int r) {
        return DoubleStream.iterate(n, numerator -> --numerator).limit(r).reduce((a, b) -> a * b).getAsDouble()
                / DoubleStream.iterate(r, denominator -> --denominator).limit(r).reduce((a, b) -> a * b).getAsDouble();
    }
}
