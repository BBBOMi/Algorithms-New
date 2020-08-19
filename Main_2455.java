package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/19.
 * 문제 출처 : https://www.acmicpc.net/problem/2455
 *
 * Time Complexity : O(1)
 * Used Algorithm : Simulation
 */

public class Main_2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0, peopleCount = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int exit = Integer.parseInt(st.nextToken());
            int entrance = Integer.parseInt(st.nextToken());

            if((peopleCount += entrance - exit) > max) {
                max = peopleCount;
            }
        }
        System.out.println(max);
    }
}
