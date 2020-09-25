package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43236
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class P43236 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int min = 1, max = distance;
        while (min <= max) {
            int count = 0;
            int pre = 0;
            int mid = (min + max) / 2;

            for (int rock : rocks) {
                if (rock - pre < mid) count++;
                else pre = rock;
            }

            if (distance - pre < mid) count++;

            if (count <= n) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
}
