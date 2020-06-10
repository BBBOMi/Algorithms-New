package me.algo.week3.programmers;

/**
 * Created by Bomi on 2020/06/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 */

public class Main_42883 {
    public String solution(String number, int k) {
        int length = number.length();
        int count = length - k;
        StringBuilder sb = new StringBuilder(count);
        int index = -1;
        while (count > 0) {
            int max = 0;
            for (int i = index + 1; i <= length - count; i++) {
                int num = number.charAt(i) - '0';
                if (max < num) {
                    max = num;
                    index = i;
                }
            }
            sb.append(max);
            count--;
        }
        return sb.toString();
    }
}
