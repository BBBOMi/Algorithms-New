package me.algo.week49.sun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bomi on 2021/04/13.
 * 문제 출처 : https://leetcode.com/problems/advantage-shuffle/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Greedy
 * Used Data structure : Array, List(ArrayList)
 */

public class Leet870 {
    private static final int EMPTY_VALUE = -1;

    public int[] advantageCount(int[] A, int[] B) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(A);
        for (int b : B) {
            int index = minValueIndex(b, A);
            if (index == A.length) index = findNotEmptyValueIndex(A);

            answer.add(A[index]);
            A[index] = EMPTY_VALUE;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int minValueIndex(int standard, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > standard) return i;
        }
        return arr.length;
    }

    private int findNotEmptyValueIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != EMPTY_VALUE) return i;
        }
        return 0;
    }
}
