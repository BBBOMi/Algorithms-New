package me.algo.week2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/05/28.
 * 문제 출처 : https://www.acmicpc.net/problem/1644
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : two-pointer
 * Used Data structure : Array
 */

public class Main_1644 {
    private static int[] primeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        setPrimeNumbers(n);
        System.out.println(countSum(n));
    }

    private static void setPrimeNumbers(int n) {
        int count = n;
        boolean[] notPrimeNumbers = new boolean[n + 1];
        notPrimeNumbers[0] = notPrimeNumbers[1] = true;
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                if(!notPrimeNumbers[j]) {
                    count--;
                }
                notPrimeNumbers[j] = true;
            }
        }
        fillPrimeNumbers(notPrimeNumbers, count);
    }

    private static void fillPrimeNumbers(boolean[] notPrimeNumbers, int n) {
        primeNumbers = new int[n];
        int index = 0;
        for (int i = 0, len = notPrimeNumbers.length; i < len; i++) {
            if (notPrimeNumbers[i]) {
                continue;
            }
            primeNumbers[index++] = i;
        }
    }

    private static int countSum(int n) {
        int count = 0;
        int sum = 0;
        int length = primeNumbers.length;
        int from = 0, to = 0;
        while (to < length) {
            if (sum < n) {
                sum += primeNumbers[to++];
                continue;
            }
            if (sum == n) {
                count++;
            }
            sum -= primeNumbers[from++];
        }
        return count;
    }
}
