package me.algo.week15.programmers;

/**
 * Created by Bomi on 2020/09/02.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12901
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math, Implementation
 * Used Data structure : Array
 */

public class Main_12901 {
    private static final String[] DAY_OF_WEEK = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    public String solution(int a, int b) {

        int days = b;
        for(int i=1; i<a; i++) {
            switch (i) {
                case 1: case 3: case 5: case 7:
                    case 8: case 10: case 12:
                        days += 31;
                        break;

                case 4: case 6: case 9: case 11:
                    days += 30;
                    break;

                default:
                    days += 29;
            }
        }
        return DAY_OF_WEEK[days%7];
    }
}
