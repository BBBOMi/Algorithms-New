package me.algo.week24;

/**
 * Created by Bomi on 2020/10/30.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68936
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Recursion
 * Used Data structure : Array
 */

public class P68936 {
    private static int countZero;
    private static int countOne;

    public int[] solution(int[][] arr) {
        int n = arr.length;
        countZero = 0;
        countOne = n * n;
        countFilledZero(0, 0, n, arr);
        return new int[]{countZero, countOne};
    }

    private void countFilledZero(int x, int y, int n, int[][] arr) {
        if (n == 0) return;
        int zero = 0, one = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] == 0) zero++;
                else one++;
            }
        }
        if (zero == n * n) {
            countZero++;
            countOne -= zero;
            return;
        }
        if (one == n * n) {
            countOne -= one;
            countOne++;
            return;
        }

        countFilledZero(x, y, n / 2, arr);
        countFilledZero(x + n / 2, y, n / 2, arr);
        countFilledZero(x, y + n / 2, n / 2, arr);
        countFilledZero(x + n / 2, y + n / 2, n / 2, arr);
    }
}
