package me.algo.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2020/09/22.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42627
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : Array, Queue(PriorityQueue)
 */

public class Main_42627 {
    public int solution(int[][] jobs) {
        int answer = 0, endTime = 0;
        int count = 0, jobIndex = 0;

        Arrays.sort(jobs, Comparator.comparingInt(arr -> arr[0]));
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));

        while (count < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= endTime) {
                heap.offer(jobs[jobIndex++]);
            }

            if(heap.isEmpty()) {
                endTime = jobs[jobIndex][0];
                continue;
            }

            answer += endTime + heap.peek()[1] - heap.peek()[0];
            endTime += heap.poll()[1];
            count++;
        }
        return answer / jobs.length;
    }
}
