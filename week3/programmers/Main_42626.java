package me.algo.week3.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/06/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42626
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(priorityQueue), List
 */

public class Main_42626 {
    private static final int TIMES_BY_TWO = 2;
    public int solution(int[] scoville, int K) {
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue(list);

        int count = 0;
        while(queue.size() > 1 && queue.peek() <= K) {
            int firstMild = queue.poll();
            int secondMild = queue.poll();

            queue.offer(firstMild + (secondMild * TIMES_BY_TWO));
            count++;
        }
        return queue.peek() >= K ? count : -1;
    }
}
