package me.algo.week40.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/02/17.
 * 문제 출처 : https://www.acmicpc.net/problem/2798
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Brute-force
 * Used Data structure : Array
 */

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(input.nextToken());
        int blackJack = Integer.parseInt(input.nextToken());

        input = new StringTokenizer(br.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(input.nextToken());
        }

        System.out.println(playBlackJack(blackJack, cardCount, cards));
    }

    private static int playBlackJack(int goal, int cardCount, int[] cards) {
        int maxSum = 0;
        for (int i = 0; i < cardCount; i++) {
            for (int j = i + 1; j < cardCount; j++) {
                for (int k = j + 1; k < cardCount; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > goal) continue;
                    if (sum == goal) return sum;
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}
