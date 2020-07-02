package me.algo;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/07/02.
 * 문제 출처 : https://www.acmicpc.net/problem/7785
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Set(TreeSet)
 */

public class Main_7785 {
    private static final String ENTER = "enter";
    private static final String LEAVE = "leave";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> enteredEmployees = new TreeSet(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (ENTER.equals(status)) {
                enteredEmployees.add(name);
                continue;
            }
            if (enteredEmployees.contains(name)) {
                enteredEmployees.remove(name);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String name : enteredEmployees) {
            bw.write(name + "\n");
        }
        bw.close();
    }
}
