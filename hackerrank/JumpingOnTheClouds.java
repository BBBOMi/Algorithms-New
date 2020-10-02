package me.algo.hackerrank;

import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        final int LENGTH = c.length;
        int[] dp = IntStream.rangeClosed(0, LENGTH).toArray();
        for(int i=2; i<LENGTH; i++) {
            if(c[i] == 1) continue;
            dp[i] = Math.min(dp[i-2], dp[i-1]) + 1;
        }
        return dp[LENGTH - 1];
    }
}
