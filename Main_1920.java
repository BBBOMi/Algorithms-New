package me.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/18.
 * 문제 출처 : https://www.acmicpc.net/problem/1920
 *
 * Time Complexity : O(logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Arrays
 */

public class Main_1920 {
    private static final int ABSENT = 0;
    private static final int EXIST = 1;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0, num; i < m; i++) {
            num = Integer.parseInt(st.nextToken());
            bw.write(isExist(num) ? EXIST + "\n" : ABSENT + "\n");
        }
        bw.close();
    }

    private static boolean isExist(int n) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n) return true;
            if (arr[mid] > n) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        return false;
    }
}
