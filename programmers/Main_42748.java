package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/07/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int[] sub = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sub);
            answer[i] = sub[commands[i][2] - 1];
        }
        return answer;
    }
}
