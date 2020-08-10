package me.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/10.
 * 문제 출처 : https://www.acmicpc.net/problem/1929
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 에라토스테네스의 체
 * Used Data structure : Array
 */

public class Main_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] primes = new boolean[n+1];
        getPrimes(primes, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=m; i<=n; i++) {
            if(primes[i]) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }

    private static void getPrimes(boolean[] primes, int n) {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for(int i=2; i*i<=n; i++) {
            for(int j=i*i; j<=n; j+=i) {
                primes[j] = false;
            }
        }
    }
}
