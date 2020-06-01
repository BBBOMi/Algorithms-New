package me.algo.week2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/28.
 * 문제 출처 : https://www.acmicpc.net/problem/1806
 *
 * Time Complexity : O(N)
 * Used Algorithm : two-pointer
 * Used Data structure : Array
 */

public class Main_1806 {
    private static final int INTEGER_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countLength(s, numbers));
    }

    protected static int countLength(int s, int[] numbers) {
        int length = numbers.length;
        int from = 0, to = 0;
        int temp, sum = 0;
        int count = INTEGER_MAX;
        while(from <= to) {
            if(sum >= s) {
                count = count > (temp = to - from) ? temp : count;
                sum -= numbers[from++];
                continue;
            }
            if(to == length) break;
            sum += numbers[to++];
        }
        return count == INTEGER_MAX ? 0 : count;
    }
}