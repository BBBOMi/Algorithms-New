package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/06/02.
 * 문제 출처 : https://www.acmicpc.net/problem/11054
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftDp = new int[n];
        for (int i = 0; i < n; i++) {
            leftDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && leftDp[i] < leftDp[j] + 1) {
                    leftDp[i] = leftDp[j] + 1;
                }
            }
        }

        int[] rightDp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && rightDp[i] < rightDp[j] + 1) {
                    rightDp[i] = rightDp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, leftDp[i] + rightDp[i]);
        }
        System.out.println(max - 1);
    }
}
