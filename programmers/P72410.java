package me.algo.programmers;

/**
 * Created by Bomi on 2021/02/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/72410
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class P72410 {
    public String solution(String new_id) {
        return new KakaoId(new_id)
                .toLowerCase()
                .removeSpecialCharacters()
                .replaceMultipleDotsToOneDot()
                .removeStartWithDotAndEndsWithDot()
                .fillAIfEmptyString()
                .makeMaxLength16()
                .makeMinLength3()
                .getId();
    }

    private static class KakaoId {
        private String id;

        KakaoId(String id) {
            this.id = id;
        }

        KakaoId toLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        KakaoId removeSpecialCharacters() {
            id = id.replaceAll("[^a-z0-9-_.]", "");
            return this;
        }

        KakaoId replaceMultipleDotsToOneDot() {
            id = id.replaceAll("\\.\\.+", ".");
            return this;
        }

        KakaoId removeStartWithDotAndEndsWithDot() {
            id = id.replaceAll("^[.]|[.]$", "");
            return this;
        }

        KakaoId fillAIfEmptyString() {
            if (id.isEmpty()) id = "a";
            return this;
        }

        KakaoId makeMaxLength16() {
            if (id.length() >= 16) id = id.substring(0, 15);
            return this;
        }

        KakaoId makeMinLength3() {
            char lastChar = id.charAt(id.length() - 1);
            while (id.length() < 3) id += lastChar;
            return this;
        }

        String getId() {
            return id;
        }
    }
}
