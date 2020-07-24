package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/1158
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }
        System.out.println(makePermutation(queue, k));
    }

    private static String makePermutation(Queue<Integer> queue, int k) {
        StringBuilder sb = new StringBuilder(queue.size() + 2);
        sb.append('<');
        for(int i=0, size=queue.size(); i<size-1; i++) {
            for(int j=0; j<k-1; j++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append('>');
        return sb.toString();
    }
}
