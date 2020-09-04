package me.algo.week16;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/09/03.
 * 문제 출처 : https://www.acmicpc.net/problem/1966
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList, PriorityQueue)
 */

public class Main_1966b {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    private static Queue<Integer> priorities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList();
            priorities = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
                priorities.offer(priority);
            }
            bw.write(getOrderNumber(m, queue) + "\n");
        }
        bw.close();
    }

    private static int getOrderNumber(int index, Queue<Document> queue) {
        int order = 0;
        while (!queue.isEmpty()) {
            Document doc = queue.poll();
            if (doc.priority != priorities.peek()) {
                queue.offer(doc);
                continue;
            }

            if (doc.index == index) return ++order;

            priorities.poll();
            order++;
        }
        return order;
    }
}
