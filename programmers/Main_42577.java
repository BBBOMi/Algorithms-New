package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/07/06.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class Main_42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[i+1])) {
                return false;
            }
        }
        return true;
    }
}
