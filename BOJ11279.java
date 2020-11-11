package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2020/11/11.
 * 문제 출처 : https://www.acmicpc.net/problem/11279
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue)
 */

public class BOJ11279 {
    private static final int NO_DATA = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                maxHeap.offer(x);
                continue;
            }

            if (maxHeap.isEmpty()) result.append(NO_DATA);
            else result.append(maxHeap.poll());
            result.append("\n");
        }

        System.out.println(result.toString());
    }
}
