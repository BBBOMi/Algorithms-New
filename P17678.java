package me.algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Bomi on 2021/07/06.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17678
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Heap
 * Used Data structure : Queue(PriorityQueue), Array
 */

public class P17678 {
    private static class Time {
        private static final int MINUTE_OF_HOUR = 60;
        int hour;
        int minute;

        Time(int hour, int minute) {
            if (minute >= MINUTE_OF_HOUR) {
                minute -= MINUTE_OF_HOUR;
                hour++;
            }

            this.hour = hour;
            this.minute = minute;
        }

        boolean isSameOrBefore(Time another) {
            return this.hour < another.hour
                    || this.hour == another.hour && this.minute < another.minute;
        }

        public String toString() {
            if (this.minute >= MINUTE_OF_HOUR) {
                this.minute -= MINUTE_OF_HOUR;
                this.hour++;
            }
            return String.format("%02d:%02d", this.hour, this.minute);
        }
    }

    private static final int FIRST_TIME_HOUR = 9;
    private static final int FIRST_TIME_MINUTE = 0;

    public String solution(int n, int t, int m, String[] timetable) {
        Comparator<Time> naturalOrder = (Time a, Time b) -> a.hour == b.hour ? a.minute - b.minute : a.hour - b.hour;
        Queue<Time> queue = new PriorityQueue<>(naturalOrder);
        for (String s : timetable) {
            String[] time = s.split(":");
            queue.offer(new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
        }
        return getLateTime(n, t, m, queue);
    }

    private String getLateTime(int busCount, int interval, int peopleCount, Queue<Time> times) {
        Time arrivalTime = new Time(FIRST_TIME_HOUR, FIRST_TIME_MINUTE);
        Time corn = new Time(FIRST_TIME_HOUR, FIRST_TIME_MINUTE);

        for (int i = 0; i < busCount; i++) {
            int people = 0;

            for (int j = 0; j < peopleCount; j++) {
                if (!times.isEmpty()) {
                    Time boardingTime = times.peek();
                    if (boardingTime.isSameOrBefore(arrivalTime)) {
                        corn = times.poll();
                        people++;
                    }
                }

                if (i < busCount - 1) continue;

                if (people == peopleCount) corn = new Time(corn.hour, corn.minute - 1);
                else if (people < peopleCount) corn = new Time(arrivalTime.hour, arrivalTime.minute);
            }
            arrivalTime = new Time(arrivalTime.hour, arrivalTime.minute + interval);
        }
        return corn.toString();
    }
}
