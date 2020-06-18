package me.algo.week4.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/12.
 * 문제 출처 : https://www.acmicpc.net/problem/1931
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_1931 {
    private static int[][] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        times = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (int[] o1, int[] o2)
                -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        System.out.println(countTimes());
    }

    private static int countTimes() {
        int start = times[0][1];
        int count = 1;
        for(int i=1, len=times.length; i<len; i++) {
            if(times[i][0] >= start) {
                start = times[i][1];
                count++;
            }
        }
        return count;
    }
}
