package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/08/17.
 * 문제 출처 : https://www.acmicpc.net/problem/9461
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_9461 {
    public static void main(String[] args) throws IOException {
        long[] sides = new long[100+1];
        initSequence(sides);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(sides[n] + "\n");
        }
        bw.close();
    }

    private static void initSequence(long[] sides) {
        sides[1] = sides[2] = sides[3] = 1;
        sides[4] = 2;
        for(int i=5, len=sides.length; i<len; i++) {
            sides[i] = sides[i-5] + sides[i-1];
        }
    }
}
