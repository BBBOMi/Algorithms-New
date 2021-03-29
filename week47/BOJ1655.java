package me.algo.week47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2021/03/29.
 * 문제 출처 : https://www.acmicpc.net/problem/1655
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue)
 */

public class BOJ1655 {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static String solution(int n) throws IOException {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int min = minHeap.poll();
                int max = maxHeap.poll();
                minHeap.offer(max);
                maxHeap.offer(min);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        return sb.toString();
    }
}
