package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/09/02.
 * 문제 출처 : https://www.acmicpc.net/problem/2161
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class Main_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(playACardGame(n));
    }

    private static String playACardGame(int n) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList(IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));
        while (queue.size() > 1) {
            sb.append(queue.poll()).append(" ");
            queue.offer(queue.poll());
        }
        return sb.append(queue.poll()).toString();
    }
}
