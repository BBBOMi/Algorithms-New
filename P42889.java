package me.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/06/28.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42889
 *
 * Time Complexity : O(N * M)
 * Used Algorithm : Implementation
 * Used Data structure : List(ArrayList), Array
 */

public class P42889 {
    private static class Stage {
        int level;
        double failure;

        public Stage(int level, double failure) {
            this.level = level;
            this.failure = failure;
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int now = 0;
            int clear = 0;

            for (int stage : stages) {
                if (i <= stage) clear++;
                if (i == stage) now++;
            }

            if (clear == 0) list.add(new Stage(i, 0));
            else list.add(new Stage(i, (double) now / clear));
        }

        list.sort((s1, s2) -> s1.failure == s2.failure ?
                Integer.compare(s1.level, s2.level) : Double.compare(s2.failure, s1.failure));
        return list.stream().mapToInt(it -> it.level).toArray();
    }
}
