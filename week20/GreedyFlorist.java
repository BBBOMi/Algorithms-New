package me.algo.week20;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/01.
 * 문제 출처 : https://www.hackerrank.com/challenges/greedy-florist/problem
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);

        int answer = 0;
        int count = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            answer += c[i] * (count++ / k + 1);
        }
        return answer;
    }
}
