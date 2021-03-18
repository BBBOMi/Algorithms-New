package me.algo.week46.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/18.
 * 문제 출처 : https://www.acmicpc.net/problem/1920
 *
 * Time Complexity : O(log N)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class BOJ1920 {
    private static final int IS_EXIST = 1;
    private static final int IS_NOT_EXIST = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(isExist(numbers, number) ? IS_EXIST : IS_NOT_EXIST).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean isExist(int[] numbers, int number) {
        int low = 0, high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (numbers[mid] == number) return true;

            if (numbers[mid] < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
