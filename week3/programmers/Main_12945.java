package me.algo.week3.programmers;

/**
 * Created by Bomi on 2020/06/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12945
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP(Memoization)
 * Used Data structure : Array
 */

public class Main_12945 {
    private static final int MOD = 1234567;
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % MOD;
        }

        return arr[n];
    }
}
