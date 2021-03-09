package me.algo.week43;

/**
 * Created by Bomi on 2021/03/09.
 * 문제 출처 : https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Divide and Conquer
 * Used Data structure : Array
 */

public class Leet240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
