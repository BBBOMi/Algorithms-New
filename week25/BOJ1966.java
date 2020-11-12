package me.algo.week25;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/11/12.
 * 문제 출처 : https://www.acmicpc.net/problem/1966
 *
 * Time Complexity : O(N^2)(worst-case)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList, PriorityQueue)
 */

public class BOJ1966 {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int wantedIndex = Integer.parseInt(st.nextToken());

            Queue<Document> printQueue = new LinkedList<>();
            Queue<Integer> priorities = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                printQueue.offer(new Document(i, priority));
                priorities.offer(priority);
            }

            int order = 0;
            while (!printQueue.isEmpty()) {
                while (printQueue.peek().priority != priorities.peek()) {
                    printQueue.offer(printQueue.poll());
                }

                if (printQueue.peek().index == wantedIndex) {
                    bw.write(++order + "\n");
                    break;
                }

                printQueue.poll();
                priorities.poll();
                order++;
            }
        }
        bw.flush();
        bw.close();
    }
}
