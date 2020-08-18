package me.algo;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://www.acmicpc.net/problem/5430
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Deque(LinkedList)
 */

public class Main_5430 {
    private static Deque<Integer> deque;
    private static final String ERROR = "error";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            initDeque(n, br.readLine());
            bw.write(executeOrders(order.toCharArray()) + "\n");
        }
        bw.close();
    }

    private static void initDeque(int n, String input) {
        String[] inputArr = input.substring(1, input.length() - 1).split(",");
        deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(inputArr[i]));
        }
    }

    private static String executeOrders(char[] orders) {
        boolean leftStart = true;
        for (char cmd : orders) {
            if (cmd == 'R') {
                leftStart = !leftStart;
                continue;
            }
            if (deque.isEmpty()) return ERROR;

            if (leftStart) deque.pollFirst();
            else deque.pollLast();
        }
        return toStringResult(leftStart);
    }

    private static String toStringResult(boolean leftStart) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Iterator<Integer> it = leftStart ? deque.iterator() : deque.descendingIterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()) sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
}
