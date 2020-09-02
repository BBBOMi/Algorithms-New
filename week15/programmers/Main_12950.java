package me.algo.week15.programmers;

/**
 * Created by Bomi on 2020/09/02.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12950
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

public class Main_12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int h = arr1.length;
        int w = arr1[0].length;
        int[][] answer = new int[h][w];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
