package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : 완전탐색
 * Used Data structure : Array
 */

public class P42839 {
    private static final int MAX_VALUE = 9999999;
    private static boolean[] primes;
    private static int answer;

    public int solution(String numbers) {
        answer = 0;
        primes = new boolean[MAX_VALUE + 1];
        initPrimes();
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, "", i, new boolean[numbers.length()]);
        }
        return answer;
    }

    private static void permutation(String origin, String number, int count, boolean[] visited) {
        if (number.length() == count) {
            int n = Integer.parseInt(number);
            if (primes[n]) {
                primes[n] = false;
                answer++;
            }
            return;
        }
        for (int i = 0; i < origin.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(origin, number + origin.charAt(i), count, visited);
                visited[i] = false;
            }
        }
    }

    private static void initPrimes() {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= MAX_VALUE; i++) {
            for (int j = i + i; j <= MAX_VALUE; j += i) {
                primes[j] = false;
            }
        }
    }
}
