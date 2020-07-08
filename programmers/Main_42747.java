package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/07/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42747
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i=0, length=citations.length; i<length; i++) {
            h = length - i;
            if(citations[i] >= h) {
                return h;
            }
        }
        return --h;
    }
}
