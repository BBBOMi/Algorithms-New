package me.algo.programmers;

/**
 * Created by Bomi on 2020/09/11.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17683
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_17683 {
    public String solution(String m, String[] musicinfos) {
        String title = "(None)";
        int maxTime = 0;
        m = replace(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");
            int time = getTime(music[0], music[1]);

            if (!isContains(m, time, music[3])) continue;
            if (maxTime < time) {
                maxTime = time;
                title = music[2];
            }
        }
        return title;
    }

    private int getTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int time = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
        time += ((Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60);
        return time;
    }

    private boolean isContains(String m, int minutes, String score) {
        StringBuilder sb = new StringBuilder();
        score = replace(score);
        int cycle = minutes / score.length();
        while (cycle-- > 0) {
            sb.append(score);
        }
        sb.append(score, 0, minutes % score.length());
        return sb.toString().contains(m);
    }

    private String replace(String score) {
        return score.replaceAll("A#", "a")
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g");
    }
}