package me.algo.week15.programmers;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/62048
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class Main_62048 {
    public long solution(int w, int h) {
        long answer = 0;
        for (long i = 0; i < w; i++) {
            answer += (long)(h * i) / w;
        }
        return answer * 2;
    }
}
