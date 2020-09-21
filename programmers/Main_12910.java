package me.algo.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/21.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12910
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_12910 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int n : arr) {
            if(n % divisor == 0) {
                answer.add(n);
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
