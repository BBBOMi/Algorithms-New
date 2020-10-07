package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12941
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class P12941 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        final int LENGTH = A.length;
        int answer = 0;
        for (int i = 0; i < LENGTH; i++) {
            answer += A[i] * B[LENGTH - 1 - i];
        }
        return answer;
    }
}
