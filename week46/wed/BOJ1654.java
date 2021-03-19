package me.algo.week46.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/19.
 * 문제 출처 : https://www.acmicpc.net/problem/1654
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lans = new int[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);
        System.out.println(solution(lans, n));
    }

    private static long solution(int[] lans, int n) {
        long low = 1, high = lans[lans.length - 1];
        long maxLength = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canBeMoreTaller(lans, mid, n)) {
                maxLength = mid;
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return maxLength;
    }

    private static boolean canBeMoreTaller(int[] lans, long height, int count) {
        return count <= Arrays.stream(lans).mapToLong(lan -> (lan / height)).reduce(Long::sum).getAsLong();
    }
}