package me.algo.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/11/02.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42862
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Queue(PriorityQueue), Array
 */

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Queue<Integer> queue = Arrays.stream(reserve).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        Queue<Integer> lostStudents = Arrays.stream(lost).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        Arrays.stream(lost).forEach(l -> {
            if (queue.contains(l)) {
                queue.remove(l);
                lostStudents.remove(l);
            }
        });

        int count = n;
        while (!queue.isEmpty() && !lostStudents.isEmpty()) {
            if (lostStudents.peek() > queue.peek() + 1) {
                queue.poll();
                continue;
            }
            if (queue.peek() - 1 <= lostStudents.peek() && lostStudents.peek() <= queue.peek() + 1) queue.poll();
            else count--;
            lostStudents.poll();
        }
        return count - lostStudents.size();
    }
}
