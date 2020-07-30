package me.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2020/07/30.
 * 문제 출처 : https://leetcode.com/problems/last-stone-weight/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Heap, Greedy
 * Used Data structure : Queue(PriorityQueue)
 */

public class Main_1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> sortedStones = new PriorityQueue(stones.length, Comparator.reverseOrder());
        Arrays.stream(stones).boxed().forEach(i -> sortedStones.offer(i));

        while (sortedStones.size() > 1) {
            sortedStones.offer(sortedStones.poll() - sortedStones.poll());
        }

        return sortedStones.poll();
    }
}
