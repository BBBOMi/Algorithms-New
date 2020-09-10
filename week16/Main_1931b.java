package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/10.
 * 문제 출처 : https://www.acmicpc.net/problem/1931
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Queue(PriorityQueue)
 */

public class Main_1931b {
    static class Meeting {
        int startTime;
        int endTime;

        Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Meeting> queue = new PriorityQueue<>(n, (Meeting m1, Meeting m2)
                -> m1.endTime != m2.endTime ? m1.endTime - m2.endTime : m1.startTime - m2.startTime);

       for(int i=0; i<n; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           queue.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
       }

       int endTime = -1;
       int count = 0;
       while (!queue.isEmpty()) {
           Meeting m = queue.poll();
           if(m.startTime < endTime) continue;

           endTime = m.endTime;
           count++;
       }

        System.out.println(count);
    }
}
