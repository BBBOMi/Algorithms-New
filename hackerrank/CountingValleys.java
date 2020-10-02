package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/counting-valleys/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        final char UPHILL = 'U';
        final char DOWNHILL = 'D';

        int h = 0;
        int valley = 0;
        for(char c : path.toCharArray()) {
            if(c == UPHILL) h++;
            if(c == DOWNHILL) h--;
            if(c == UPHILL && h == 0) valley++;
        }
        return valley;
    }
}
