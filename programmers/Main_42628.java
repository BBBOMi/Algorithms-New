package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/09/22.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42628
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue), Array
 */

public class Main_42628 {
    public int[] solution(String[] operations) {
        Queue<Integer> minQueue = new PriorityQueue();
        Queue<Integer> maxQueue = new PriorityQueue(Comparator.reverseOrder());

        for(String operation : operations) {
            String[] order = operation.split(" ");
            if("I".equals(order[0])) {
                minQueue.offer(Integer.parseInt(order[1]));
                maxQueue.offer(Integer.parseInt(order[1]));
                continue;
            }

            if(maxQueue.isEmpty()) continue;

            int index = Integer.parseInt(order[1]);
            if(index == 1) {
               minQueue.remove(maxQueue.poll());
            } else {
                maxQueue.remove(minQueue.poll());
            }
        }

        return maxQueue.isEmpty() ? new int[]{0, 0} : new int[]{maxQueue.peek(), minQueue.peek()};
    }
}
