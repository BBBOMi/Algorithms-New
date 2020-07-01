package me.algo;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/07/01.
 * 문제 출처 : https://www.acmicpc.net/problem/1620
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Map(TreeMap)
 */

public class Main_1620 {
    private static String[] dictionary;
    private static Map<String, Integer> nameDictionary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dictionary = new String[n + 1];
        nameDictionary = new TreeMap();
        for (int i = 1; i <= n; i++) {
            dictionary[i] = br.readLine();
            nameDictionary.put(dictionary[i], i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0, index; i<m; i++) {
            String question = br.readLine();
            if('0' < question.charAt(0) && question.charAt(0) <= '9') {
                index = Integer.parseInt(question);
                bw.write(dictionary[index] + "\n");
            } else {
                bw.write(nameDictionary.get(question) + "\n");
            }
        }
        bw.close();
    }
}
