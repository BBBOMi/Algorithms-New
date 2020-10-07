package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42897
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P42897 {
    public int solution(int[] money) {
        final int LENGTH = money.length;
        int[] dp1 = new int[LENGTH];
        int[] dp2 = new int[LENGTH];

        dp1[0] = dp1[1] = money[0];
        dp2[1] = money[1];

        for (int i = 2; i < LENGTH; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }
        return Math.max(dp1[LENGTH - 2], dp2[LENGTH - 1]);
    }
}
