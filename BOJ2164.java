package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/07/09.
 * 문제 출처 : https://www.acmicpc.net/problem/2164
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int last = lastCard(cards);
        System.out.println(last);
    }

    private static int lastCard(Queue<Integer> cards) {
        while (cards.size() > 1) {
            cards.poll();
            cards.offer(cards.poll());
        }
        return cards.poll();
    }
}
