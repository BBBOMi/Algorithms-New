package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/07/06.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i=0;
        for( ; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }
}
