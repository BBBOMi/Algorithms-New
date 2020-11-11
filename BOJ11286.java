package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2020/11/11.
 * 문제 출처 : https://www.acmicpc.net/problem/11286
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Heap, Sort
 * Used Data structure : Queue(PriorityQueue)
 */

public class BOJ11286 {
    private static final int NO_DATA = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Comparator<Integer> comp = (x1, x2) -> (Math.abs(x1) == Math.abs(x2) ? x1 - x2 : Math.abs(x1) - Math.abs(x2));
        Queue<Integer> absHeap = new PriorityQueue<>(comp);
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x != 0) {
                absHeap.offer(x);
                continue;
            }

            if(absHeap.isEmpty()) result.append(NO_DATA);
            else result.append(absHeap.poll());
            result.append("\n");
        }

        System.out.println(result.toString());
    }
}
