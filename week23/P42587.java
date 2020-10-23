package me.algo.week23;

import java.util.*;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList, PriorityQueue), Array
 */

public class P42587 {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Document> printQueue = new LinkedList<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            printQueue.offer(new Document(i, priorities[i]));
            priorityQueue.offer(priorities[i]);
        }

        int printOrder = 0;
        while (!printQueue.isEmpty()) {
            printOrder++;
            while (printQueue.peek().priority != priorityQueue.peek()) {
                printQueue.offer(printQueue.poll());
            }
            priorityQueue.poll();
            Document document = printQueue.poll();
            if (document.index == location) return printOrder;
        }
        return printOrder;
    }
}
