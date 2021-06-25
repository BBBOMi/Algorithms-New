package me.algo;

/**
 * Created by Bomi on 2021/06/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12947
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math
 */

public class P12947 {
    public boolean solution(int x) {
        return x % Integer.toString(x).chars().map(it -> it - '0').sum() == 0;
//        int copy = x;
//        int num = 0;
//        while (copy != 0) {
//            num += copy % 10;
//            copy /= 10;
//        }
//        return x % num == 0;
    }
}
