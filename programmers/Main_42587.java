package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/07/01.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort, 자료구조
 * Used Data structure : Queue(LinkedList, PriorityQueue), Array
 */

public class Main_42587 {
    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Integer> printPriority = new PriorityQueue((i1, i2) -> (Integer)i2 - (Integer)i1);
        Queue<Pair> printQueue = new LinkedList();
        for(int i=0; i<priorities.length; i++) {
            printQueue.offer(new Pair(priorities[i], i));
            printPriority.offer(priorities[i]);
        }

        int answer = 0;
        while (!printQueue.isEmpty()) {
            if(printPriority.peek() == printQueue.peek().value) {
                if(printQueue.peek().index == location) {
                    return ++answer;
                }
                printPriority.poll();
                printQueue.poll();
                answer++;
                continue;
            }
            printQueue.offer(printQueue.poll());
        }
        return answer;
    }
}
