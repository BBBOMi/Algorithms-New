package me.algo.week8;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Bomi on 2020/07/14.
 * 문제 출처 : https://www.acmicpc.net/problem/5052
 *
 * Time Complexity : O(N)
 * Used Algorithm : 문자열
 * Used Data structure : Array
 */

public class Main_5052 {
    private static final String CONSISTENCY = "YES";
    private static final String INCONSISTENCY = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            for(int j=0; j<n; j++) {
                phoneNumbers[j] = br.readLine();
            }
            bw.write(isStartsWith(phoneNumbers) ? INCONSISTENCY + "\n" : CONSISTENCY + "\n");
        }
        bw.close();
    }

    private static boolean isStartsWith(String[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i].startsWith(arr[i+1]) || arr[i+1].startsWith(arr[i])) {
                return true;
            }
        }
        return false;
    }
}
