package me.algo.week20;

/**
 * Created by Bomi on 2020/10/01.
 * 문제 출처 : https://www.hackerrank.com/challenges/the-time-in-words/problem
 *
 * Time Complexity : O(1)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class TheTimeInWords {
    private static final String[] TIMES = {" o' clock",
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "quarter",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    private static final String PAST = " past ";
    private static final String TO = " to ";
    private static final String MINUTES = " minutes";
    private static final String MINUTE = " minute";

    private static final String HALF = "half";

    static String timeInWords(int h, int m) {
        if (m == 0) return TIMES[h] + TIMES[m];

        boolean isMoreThanHalf = m > 30;
        if (isMoreThanHalf) {
            m = 60 - m;
            h = h % 12 + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getMinute(m));
        if (m % 15 != 0) sb.append(m == 1 ? MINUTE : MINUTES);
        sb.append(isMoreThanHalf ? TO : PAST);
        sb.append(TIMES[h]);
        return sb.toString();
    }

    private static String getMinute(int m) {
        if (m == 30) return HALF;
        if (m > 20) return TIMES[20] + " " + TIMES[m - 20];
        return TIMES[m];
    }
}
