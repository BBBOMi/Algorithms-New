package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/19.
 * 문제 출처 : https://www.acmicpc.net/problem/1057
 *
 * Time Complexity : O(logN)
 * Used Algorithm : Math, Simulation
 */

public class Main_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 0;
        while(kim != lim) {
            kim = (kim+1)/2;
            lim = (lim+1)/2;
            round++;
        }

        System.out.println(round);
    }
}
