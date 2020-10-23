package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12977
 *
 * Time Complexity : O(N)
 * Used Algorithm : Backtracking
 * Used Data structure : Array
 */

public class P12977 {
    private static boolean[] primes;

    public int solution(int[] nums) {
        final int MAX = 3000;
        primes = new boolean[MAX];
        initPrimes();
        return countPrimes(nums, 0, 3, 0, 0);
    }

    private int countPrimes(int[] nums, int start, int size, int sum, int count) {
        if (count == size) return primes[sum] ? 1 : 0;
        int primeCount = 0;
        for (int i = start; i < nums.length; i++) {
            primeCount += countPrimes(nums, i + 1, size, sum + nums[i], count + 1);
        }
        return primeCount;
    }

    private void initPrimes() {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i + i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }
    }
}
