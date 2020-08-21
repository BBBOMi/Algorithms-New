package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/21.
 * 문제 출처 : https://www.acmicpc.net/problem/2798
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Brute-force
 * Used Data structure : Array
 */

public class Main_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(playBlackjack(m, cards));
    }

    private static int playBlackjack(int goal, int[] cards) {
        int sum, max = 0;
        for(int i=0, len=cards.length; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=j+1; k<len; k++) {
                    if((sum = cards[i] + cards[j] + cards[k]) == goal) return sum;

                    if(sum > goal) continue;
                    if(sum > max) max = sum;
                }
            }
        }
        return max;
    }
}
