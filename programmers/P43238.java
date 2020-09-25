package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/09/24.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43238
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class P43238 {
    public long solution(int n, int[] times) {
        long min = 1, max = (long)Arrays.stream(times).max().getAsInt() * n;
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            long done = 0;
            for (int time : times) {
                done += mid / time;
            }
            if (done >= n) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
