package me.algo.week1.dp;

/**
 * Created by Bomi on 2020/05/19.
 * 문제 출처 :
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_DP {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }

    public static int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        int[] stair = new int[n+1];
        stair[1] = 1;
        stair[2] = 2;
        for(int i=3; i<=n; i++) {
            stair[i] = stair[i-1] + stair[i-2];
        }

        return stair[n];
    }
}
