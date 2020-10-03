package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/03.
 * 문제 출처 : https://www.hackerrank.com/challenges/new-year-chaos/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class NewYearChaos {
    private static int totalCount;
    static final String INVALID = "Too chaotic";

    static String minimumBribes(int[] q) {
        final int STANDARD_COUNT = 2;
        totalCount = 0;

        for (int maxNumber = q.length; maxNumber > 0; maxNumber--) {
            int maxNumberIdx = maxNumber - 1;
            while (maxNumberIdx >= 0 && q[maxNumberIdx] != maxNumber) maxNumberIdx--;
            int diff = Math.abs((maxNumber - 1) - maxNumberIdx);
            if (diff > STANDARD_COUNT) return INVALID;

            totalCount += diff;
            swapOfRange(maxNumberIdx, maxNumber - 1, q);
        }
        return String.valueOf(totalCount);
    }

    private static void swapOfRange(int startIndex, int fromIndex, int[] arr) {
        for (int i = startIndex; i < fromIndex; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
