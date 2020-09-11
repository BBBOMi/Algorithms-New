package me.algo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2020/09/11.
 * 문제 출처 : https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조, 정렬
 * Used Data structure : Queue(PriorityQueue), Array
 */

public class Main_215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums) {
            queue.offer(n);
        }

        for(int i=1; i<k; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
