package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bomi on 2020/07/23.
 * 문제 출처 : https://leetcode.com/problems/queue-reconstruction-by-height/submissions/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople,
                (int[] arr1, int[] arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr2[0] - arr1[0]);

        List<int[]> result = new ArrayList<>();
        for (int[] cur : sortedPeople) {
            result.add(cur[1], cur);
        }

        return result.toArray(new int[result.size()][]);
    }
}
