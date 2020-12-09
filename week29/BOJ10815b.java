package me.algo.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/12/09.
 * 문제 출처 : https://www.acmicpc.net/problem/10815
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Set(HashSet)
 */

public class BOJ10815b {
    private static final int HAVING_A_CARD = 1;
    private static final int DONT_HAVING_A_CARD = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> cards = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (cards.contains(Integer.parseInt(st.nextToken()))) sb.append(HAVING_A_CARD);
            else sb.append(DONT_HAVING_A_CARD);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
