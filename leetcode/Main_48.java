package me.algo.leetcode;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://leetcode.com/problems/rotate-image/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Main_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int head = -1, tail = n;
        while(++head < --tail) {
            int[] temp = matrix[head];
            matrix[head] = matrix[tail];
            matrix[tail] = temp;
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                swap(i ,j, matrix);
            }
        }
    }

    private static void swap(int i, int j, int[][] origin) {
        int temp = origin[i][j];
        origin[i][j] = origin[j][i];
        origin[j][i] = temp;
    }
}
