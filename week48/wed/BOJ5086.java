package me.algo.week48.wed;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/01.
 * 문제 출처 : https://www.acmicpc.net/problem/5086
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class BOJ5086 {
    private static final String FACTOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (StringTokenizer st = new StringTokenizer(br.readLine()); ; st = new StringTokenizer(br.readLine())) {
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 == num2) {
                bw.close();
                return;
            }

            if (isFactor(num1, num2)) {
                bw.write(FACTOR + "\n");
                continue;
            }
            if (isMultiple(num1, num2)) {
                bw.write(MULTIPLE + "\n");
                continue;
            }
            bw.write(NEITHER + "\n");
        }
    }

    private static boolean isFactor(int a, int b) {
        return b % a == 0;
    }

    private static boolean isMultiple(int a, int b) {
        return a % b == 0;
    }

}
