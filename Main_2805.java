package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/18.
 * 문제 출처 : https://www.acmicpc.net/problem/2805
 *
 * Time Complexity : O(logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class Main_2805 {
    private static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = max < trees[i] ? trees[i] : max;
        }
        System.out.println(getCutterMaxHeight(m, max));
    }

    private static int getCutterMaxHeight(int requiredHeight, int maxHeight) {
        int low = 1, high = maxHeight;
        int cutterHeight = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(canBeSmaller(mid, requiredHeight)) {
                cutterHeight = mid;
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return cutterHeight;
    }

    private static boolean canBeSmaller(int mid, int requiredHeight) {
        long sum = 0;
        for(int i=trees.length-1; i>=0; i--) {
            if(trees[i] <= mid) continue;
            sum += trees[i] - mid;
        }
        return sum >= requiredHeight;
    }
}
