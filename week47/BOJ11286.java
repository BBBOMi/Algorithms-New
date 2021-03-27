package me.algo.week47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2021/03/27.
 * 문제 출처 : https://www.acmicpc.net/problem/11286
 *
 * Time Complexity : O(N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue)
 */

public class BOJ11286 {
    private static BufferedReader br;

    private static final int POLL_OPERATION = 0;
    private static final int NO_VALUE = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static String solution(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> absQueue = new PriorityQueue<>((n1, n2) -> Math.abs(n1) == Math.abs(n2) ? n1 - n2 : Math.abs(n1) - Math.abs(n2));
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num != POLL_OPERATION) {
                absQueue.offer(num);
                continue;
            }

            if (absQueue.isEmpty()) sb.append(NO_VALUE);
            else sb.append(absQueue.poll());
            sb.append("\n");
        }
        return sb.toString();
    }
}
