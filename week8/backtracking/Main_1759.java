package me.algo.week8.backtracking;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/07/15.
 * 문제 출처 : https://www.acmicpc.net/problem/1759
 *
 * Time Complexity : O(N)
 * Used Algorithm : Backtracking. Recursion
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_1759 {
    private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] alphabets = new String[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreElements(); i++) {
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);
        findPassword(0, l, alphabets, new ArrayList<>());
        bw.close();
    }

    private static void findPassword(int index, int length, String[] alphabets, List<String> passwords) throws IOException {
        if (passwords.size() == length) {
            printPassword(passwords);
            return;
        }
        for (int i = index; i < alphabets.length; i++) {
            if (passwords.contains(alphabets[i])) {
                continue;
            }
            passwords.add(alphabets[i]);
            findPassword(i + 1, length, alphabets, passwords);
            passwords.remove(alphabets[i]);
        }
    }

    private static boolean isContainsVowels(List<String> passwords) {
        int vowelsCount = 0;
        for(String s : passwords) {
            for(char c : vowels) {
                if(s.charAt(0) == c) {
                    vowelsCount++;
                }
            }
        }

        if(vowelsCount < 1) return false; // 최소 한 개의 모음이 포함되어 있어야 함
        if(passwords.size() - vowelsCount < 2) return false; // 최소 두 개의 자음이 포함 되어 있어야 함
        return true;
    }

    private static void printPassword(List<String> passwords) throws IOException {
        if(!isContainsVowels(passwords)) return;
        for(String s : passwords) {
            bw.write(s);
        }
        bw.write("\n");
    }
}
