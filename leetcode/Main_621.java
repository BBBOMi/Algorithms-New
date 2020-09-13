package me.algo.leetcode;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/09/01.
 * 문제 출처 : https://leetcode.com/problems/task-scheduler/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_621 {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        char[] numberOfTask = new char[26];
        for(char c : tasks) {
            numberOfTask[c-'A']++;
        }

        Arrays.sort(numberOfTask);
        int chunk = numberOfTask[25] - 1;
        int idleSpots = chunk * n;

        for(int i=24; i>=0; i--) {
            idleSpots -= Math.min(chunk, numberOfTask[i]);
        }

        return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
    }
}
