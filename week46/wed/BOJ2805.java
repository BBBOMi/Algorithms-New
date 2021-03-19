package me.algo.week46.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/19.
 * 문제 출처 : https://www.acmicpc.net/problem/2805
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int highest = 0;
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            highest = Math.max(highest, trees[i]);
        }

        System.out.println(solution(trees, highest, m));
    }

    private static int solution(int[] trees, int highest, int goal) {
        int low = 0, high = highest;
        int maxHeight = 0;
        while (low <= high) {
            int mid = (int) (((long) low + high) / 2);
            if (canBeMoreHigher(trees, mid, goal)) {
                maxHeight = mid;
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return maxHeight;
    }

    private static boolean canBeMoreHigher(int[] trees, long cutOfLength, int goal) {
        return goal <= Arrays.stream(trees).filter(tree -> tree > cutOfLength).mapToLong(tree -> tree - cutOfLength).sum();
    }
}
