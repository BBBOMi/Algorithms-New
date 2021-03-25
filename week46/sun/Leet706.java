package me.algo.week46.sun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/03/25.
 * 문제 출처 : https://leetcode.com/problems/design-hashmap/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implements
 * Used Data structure : List(ArrayList)
 */

public class Leet706 {
    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node(int key) {
            this(key, 0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key;
        }
    }

    private static class MyHashMap {
        private List<Node> nodes;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            nodes = new ArrayList<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            remove(key);
            nodes.add(new Node(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return nodes.stream()
                    .filter(node -> node.key == key)
                    .mapToInt(node -> node.value)
                    .findFirst()
                    .orElse(-1);
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            nodes.removeIf(node -> node.key == key);
        }
    }
}
