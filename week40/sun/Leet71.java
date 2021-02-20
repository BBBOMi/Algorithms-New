package me.algo.week40.sun;

import java.util.Stack;

/**
 * Created by Bomi on 2021/02/20.
 * 문제 출처 : https://leetcode.com/problems/simplify-path/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String, Stack
 * Used Data structure : Stack
 */

public class Leet71 {
    private static final String SLASH = "/";
    private static final String PARENT_DIRECTORY = "..";
    private static final String CURRENT_DIRECTORY = ".";

    public String simplifyPath(String path) {
        Stack<String> directoryNames = new Stack<>();

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char ch = path.charAt(i);
            if (ch == '/') continue;

            String directoryName = getDirectoryName(path, i);
            simplify(directoryName, directoryNames);
            i += directoryName.length();
        }
        return getCanonicalPath(directoryNames);
    }

    private String getDirectoryName(String path, int currentIndex) {
        int nextSlashIndex = path.indexOf(SLASH, currentIndex);
        if (nextSlashIndex < 0) nextSlashIndex = path.length();
        return path.substring(currentIndex, nextSlashIndex);
    }

    private void simplify(String directoryName, Stack<String> directoryNames) {
        if (CURRENT_DIRECTORY.equals(directoryName)) return;
        if (PARENT_DIRECTORY.equals(directoryName)) {
            if (!directoryNames.isEmpty()) directoryNames.pop();
        } else directoryNames.push(directoryName);
    }

    private String getCanonicalPath(Stack<String> directoryNames) {
        StringBuilder canonicalPath = new StringBuilder();
        directoryNames.forEach(name -> canonicalPath.append(SLASH).append(name));
        return canonicalPath.length() == 0 ? SLASH : canonicalPath.toString();
    }
}
