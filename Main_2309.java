package me.algo;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://www.acmicpc.net/problem/2309
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Brute-force
 * Used Data structure : Array
 */

public class Main_2309 {
    private static final int DWARFS_HEIGHT_SUM = 100;
    private static int fakeIdx1, fakeIdx2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);
        findFakeDwarfs(heights, sum);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<9; i++) {
            if(i == fakeIdx1 || i == fakeIdx2) continue;
            bw.write(heights[i] + "\n");
        }
        bw.close();
    }

    private static void findFakeDwarfs(int[] heights, int sum) {
        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - (heights[i] + heights[j]) == DWARFS_HEIGHT_SUM) {
                    fakeIdx1 = i;
                    fakeIdx2 = j;
                    return;
                }
            }
        }
    }
}
