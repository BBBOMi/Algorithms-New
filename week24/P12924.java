package me.algo.week24;

/**
 * Created by Bomi on 2020/10/30.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12924
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 */

public class P12924 {
    public int solution(int n) {
        int left = 0, right = 0;
        int sum = left + right;
        int count = 0;
        while (left <= right && right <= n) {
            if (sum < n) {
                sum += ++right;
                continue;
            }
            if (sum == n) {
                count++;
            }
            sum -= ++left;
        }
        return count;
    }
}
