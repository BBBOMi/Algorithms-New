package me.algo.programmers;

/**
 * Created by Bomi on 2020/11/09.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/70130
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class P70130 {
    public int solution(int[] a) {
        int answer = 0;
        int maxCountNum = 0, maxCount = 0;
        int[] count = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
            if (count[a[i]] > maxCount) {
                maxCount = count[a[i]];
                maxCountNum = a[i];
            }
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != maxCountNum && a[i + 1] != maxCountNum) continue;
            if (a[i] == maxCountNum && a[i + 1] == maxCountNum) continue;

            answer += 2;
            i++;
        }
        return answer;
    }
}
