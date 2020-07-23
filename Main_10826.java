package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Bomi on 2020/07/23.
 * 문제 출처 : https://www.acmicpc.net/problem/10826
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static BigInteger fibonacci(int n) {
        if(n == 0) return new BigInteger("0");

        BigInteger[] arr = new BigInteger[n+1];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        return arr[n];
    }
}
