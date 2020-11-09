package me.algo.programmers;

/**
 * Created by Bomi on 2020/11/09.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12980
 *
 * Time Complexity : O(logN)
 * Used Algorithm : DP
 */

public class P12980 {
    public int solution(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 != 0) {
                count++;
                n--;
            }
            n /= 2;
        }
        return ++count;
    }
}
