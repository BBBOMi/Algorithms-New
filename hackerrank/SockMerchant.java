package me.algo.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/sock-merchant/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Map(HashMap), Set, Array
 */

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        final int PAIR = 2;
        Map<Integer, Integer> socks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            socks.put(ar[i], socks.getOrDefault(ar[i], 0) + 1);
        }

        int count = 0;
        for (int sockNumber : socks.keySet()) {
            count += socks.get(sockNumber) / PAIR;
        }
        return count;
    }
}
