package me.algo.week4.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/11.
 * 문제 출처 : https://www.acmicpc.net/problem/2343
 *
 * Time Complexity : O(logN)
 * Used Algorithm : Binary Search
 * Used Data structure : Array
 */

public class Main_2343 {
    private static int m;
    private static int[] lessonMinutes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lessonMinutes = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<n; i++) {
            lessonMinutes[i] = Integer.parseInt(st.nextToken());
            sum += lessonMinutes[i];
        }

        int low = 1, high = sum;
        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isReducible(mid)) {
                result = mid;
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        System.out.println(result);
    }

   private static boolean isReducible(int high) {
        int sum = 0;
        int count = 1;

        for(int i=0; i<lessonMinutes.length; i++) {
            if(lessonMinutes[i] > high) {
                return false;
            }
            sum += lessonMinutes[i];
            if(sum > high) {
                sum = lessonMinutes[i];
                count++;
            }
        }
        return m >= count;
   }
}
