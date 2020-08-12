package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bomi on 2020/08/12.
 * 문제 출처 : https://www.acmicpc.net/problem/11652
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class Main_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] cards = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        System.out.println(getMaxCardNumber(cards));
    }

    private static long getMaxCardNumber(long[] cards) {
        Arrays.sort(cards);
        int count = 1, max = 0;
        int index = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i] == cards[i + 1]) {
                count++;
                if (count > max) {
                    max = count;
                    index = i;
                }
                continue;
            }
            count = 1;
        }
        return cards[index];
    }
}
