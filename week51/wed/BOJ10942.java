package me.algo.week51.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/27.
 * 문제 출처 : https://www.acmicpc.net/problem/10942
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ10942 {
    private static final int PALINDROME = 1;
    private static final int NOT_PALINDROME = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] palindromes = new boolean[n + 1][n + 1];
        checkPalindrome(numbers, palindromes);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(isPalindrome(start, end, palindromes) ? PALINDROME : NOT_PALINDROME).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void checkPalindrome(int[] numbers, boolean[][] palindromes) {
        for (int i = 1; i < palindromes.length; i++) {
            palindromes[i][i] = true;
            if (numbers[i - 1] == numbers[i]) palindromes[i - 1][i] = palindromes[i][i - 1] = true;
        }

        for (int i = 1; i < palindromes.length - 1; i++) {
            for (int j = 1; j + i < palindromes.length; j++) {
                if (numbers[j] == numbers[j + i] && palindromes[j + 1][j + i - 1]) {
                    palindromes[j][j + i] = palindromes[j + i][j] = true;
                }
            }
        }
    }

    private static boolean isPalindrome(int start, int end, boolean[][] arr) {
        return arr[start][end];
    }
}
