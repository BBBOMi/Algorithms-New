package me.algo.week16;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/03.
 * 문제 출처 : https://www.acmicpc.net/problem/1966
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_1966 {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    private static int[] priorities;

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
            priorities = new int[n];
            for (int i = 0; i < n; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priorities[i]));
            }
            Arrays.sort(priorities);
            bw.write(getOrderNumber(m, queue) + "\n");
        }
        bw.close();
    }

    private static int getOrderNumber(int index, Queue<Document> queue) {
        int order = 0, prioritiesIndex = priorities.length - 1;
        while (!queue.isEmpty()) {
            Document doc = queue.poll();
            if (doc.priority != priorities[prioritiesIndex]) {
                queue.offer(doc);
                continue;
            }
            if (doc.index == index) return ++order;
            prioritiesIndex--;
            order++;
        }
        return order;
    }
}
