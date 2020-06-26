package me.algo.week6.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/26.
 * 문제 출처 : https://www.acmicpc.net/problem/2798
 *
 * Time Complexity : O(N)
 * Used Algorithm : 구현
 * Used Data structure : Array
 */

public class Main_2798 {
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreElements(); i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(searchCards(cards));
    }

    private static int searchCards(int[] cards) {
        int result = 0;
        for(int i=0, max=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1, sum; k<n; k++) {
                    if((sum = cards[i] + cards[j] + cards[k]) == m) {
                        return sum;
                    } else if(sum > m) {
                        continue;
                    }
                    max = sum > max ? sum : max;
                }
            }
            result = max;
        }
        return result;
    }
}
