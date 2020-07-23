package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/07/23.
 * 문제 출처 : https://www.acmicpc.net/problem/10826
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class Main_10826b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static BigInteger fibonacci(int n) {
        if(n == 0) return BigInteger.ZERO;

        Queue<BigInteger> queue = new LinkedList<>();
        queue.offer(BigInteger.ZERO);
        queue.offer(BigInteger.ONE);

        for(int i=1; i<=n; i++) {
            queue.offer(queue.poll().add(queue.peek()));
        }
        return queue.peek();
    }
}
