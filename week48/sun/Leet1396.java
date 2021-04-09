package me.algo.week48.sun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bomi on 2021/04/09.
 * 문제 출처 : https://leetcode.com/problems/design-underground-system/
 *
 * Used Algorithm : Implement
 * Used Data structure : Map(HashMap)
 */

public class Leet1396 {
    private static class Passenger {
        String station;
        int time;

        Passenger(String stationName, int time) {
            this.station = stationName;
            this.time = time;
        }
    }

    private static class Station {
        int visitedCount;
        int duringTime;

        Station(int visitedCount, int duringTime) {
            this.visitedCount = visitedCount;
            this.duringTime = duringTime;
        }
    }

    private static class UndergroundSystem {
        private Map<Integer, Passenger> checkInMap;
        private Map<String, Station> checkOutMap;

        public UndergroundSystem() {
            this.checkInMap = new HashMap<>();
            this.checkOutMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            this.checkInMap.put(id, new Passenger(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Passenger passenger = this.checkInMap.get(id);
            String key = passenger.station + "-" + stationName;

            Station station = this.checkOutMap.computeIfAbsent(key, (value) -> new Station(0, 0));
            station.visitedCount++;
            station.duringTime += t - passenger.time;
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            Station found = checkOutMap.getOrDefault(key, new Station(1, 0)); // to prevent division by zero
            return (double) found.duringTime / found.visitedCount;
        }
    }
}
