package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/07/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue = new LinkedList();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            int progress = (100 - progresses[i]);
            int day = progress / speeds[i];
            if(progress % speeds[i] != 0) day++;
            progressQueue.offer(day);
        }

        while(!progressQueue.isEmpty()) {
            int day = progressQueue.peek();
            int work = 0;
            while(!progressQueue.isEmpty() && progressQueue.peek() <= day) {
                progressQueue.poll();
                work++;
            }
            answer.add(work);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
