package me.algo.week48.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/04/05.
 * 문제 출처 : https://www.acmicpc.net/problem/2981
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array, List(ArrayList)
 */

public class BOJ2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i] - nums[i - 1]; // save diff
        }

        int gcd = nums[0];
        for (int i = 1; i < n - 1; i++) {
            gcd = gcd(gcd, nums[i]);
        }

        List<Integer> answer = makeMList(gcd);
        System.out.println(answer.stream().map(it -> it + " ").collect(Collectors.joining()));
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static List<Integer> makeMList(int gcd) {
        return IntStream.rangeClosed(2, gcd).filter(it -> gcd % it == 0).sorted().boxed().collect(Collectors.toList());
    }
}
