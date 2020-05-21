package me.algo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/19.
 * 문제 출처 : https://www.acmicpc.net/problem/1476
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : mathematics
 * Used Data structure : 
 */

public class Main_1476 {
    private static final int NUMBER_E = 15;
    private static final int NUMBER_S = 28;
    private static final int NUMBER_M = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken()) - 1;
        int s = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(st.nextToken()) - 1;

        int i = 1;
        for(; ; i++) {
            int modE = i % NUMBER_E;
            int modS = i % NUMBER_S;
            int modM = i % NUMBER_M;

            if(modE == e && modS == s && modM == m) {
                System.out.println(++i);
                return;
            }
        }
    }
}
