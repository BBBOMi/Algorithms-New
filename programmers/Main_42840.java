package me.algo.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42840
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_42840 {
    public int[] solution(int[] answers) {
        final int[] PERSON1 = {1, 2, 3, 4, 5};
        final int[] PERSON2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] PERSON3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[4];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == PERSON1[i%PERSON1.length]) score[1]++;
            if (answers[i] == PERSON2[i%PERSON2.length]) score[2]++;
            if (answers[i] == PERSON3[i%PERSON3.length]) score[3]++;
        }

        int maxScore = Math.max(score[1], Math.max(score[2], score[3]));

        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=3; i++) {
            if(maxScore == score[i]) {
                answer.add(i);
            }
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
