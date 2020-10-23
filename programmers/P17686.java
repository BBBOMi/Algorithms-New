package me.algo.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17686
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class P17686 {
    static class File {
        String head;
        int number;
        String tail;
        String originFullName;

        File(String head, int number, String tail, String originFullName) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.originFullName = originFullName;
        }
    }
    public String[] solution(String[] files) {
        return Arrays.stream(files).map(f -> {
            int numberIndex = 0;
            int tailIndex = f.length();
            for(int i=0; i<f.length(); i++) {
                if(Character.isDigit(f.charAt(i)) && numberIndex == 0) numberIndex = i;
                if(!Character.isDigit(f.charAt(i)) && numberIndex != 0) {
                    tailIndex = i;
                    break;
                }
            }
            String tail = "";
            if(tailIndex != f.length()) tail = f.substring(tailIndex);
            return new File(f.substring(0, numberIndex).toUpperCase(), Integer.parseInt(f.substring(numberIndex, tailIndex)), tail, f);
        }).sorted(Comparator.comparing(file -> file.number))
                .sorted(Comparator.comparing(file -> file.head)).map(f -> f.originFullName).toArray(String[]::new);
    }
}
