package me.algo.week19;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/24.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_42842 {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        List<Integer> divisor = new ArrayList<>();
        for(int i=3; i<=area; i++) {
            if(area / i < 3) break;
            if(area % i == 0) {
                divisor.add(i);
            }
        }

        int width = 0, height = 0;
        for(int i=0; i<divisor.size(); i++) {
            width = divisor.get(i);
            height = area / width;

            if(width < height) continue;
            if(width * 2 + (height - 2) * 2 == brown) break;
        }

        return new int[]{width, height};
    }
}
