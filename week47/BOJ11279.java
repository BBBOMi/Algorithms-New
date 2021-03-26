package me.algo.week47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2021/03/26.
 * 문제 출처 : https://www.acmicpc.net/problem/11279
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue)
 */

public class BOJ11279 {
    private static BufferedReader br;

    private static final int POLL_MAX_VALUE = 0;
    private static final int NO_VALUE = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static String solution(int n) throws IOException {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != POLL_MAX_VALUE) {
                maxHeap.offer(num);
                continue;
            }

            if (maxHeap.isEmpty()) sb.append(NO_VALUE);
            else sb.append(maxHeap.poll());
            sb.append("\n");
        }
        return sb.toString();
    }
}
