package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12953
 *
 * Time Complexity : O(N)
 * Used Algorithm : Euclidean
 * Used Data structure : Array
 */

public class P12953 {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b != 0) return gcd(b, a % b);
        return a;
    }

}
