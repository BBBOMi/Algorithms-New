package me.algo.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/12/09.
 * 문제 출처 : https://www.acmicpc.net/problem/10815
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class BOJ10815 {
    private static final int HAVING_A_CARD = 1;
    private static final int DONT_HAVING_A_CARD = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(havingACard(Integer.parseInt(st.nextToken()), cards)) sb.append(HAVING_A_CARD);
            else sb.append(DONT_HAVING_A_CARD);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static boolean havingACard(int cardNumber, int[] cards) {
        return Arrays.binarySearch(cards, cardNumber) >= 0;
    }
}
