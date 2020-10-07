package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12949
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class P12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int h = arr1.length, w = arr2[0].length;
        int[][] answer = new int[h][w];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                answer[i][j] = multiply(arr1, arr2, i, j);
            }
        }
        return answer;
    }

    private static int multiply(int[][] arr1, int[][] arr2, int x, int y) {
        int multiplySum = 0;
        for(int i=0; i<arr1[0].length; i++) {
            multiplySum += arr1[x][i] * arr2[i][y];
        }
        return multiplySum;
    }
}
