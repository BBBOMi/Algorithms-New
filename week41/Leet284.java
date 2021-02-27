package me.algo.week41;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bomi on 2021/02/27.
 * 문제 출처 : https://leetcode.com/problems/peeking-iterator/
 *
 * Used Algorithm : Design
 * Used Data structure : List(ArrayList)
 */

public class Leet284 {

    class PeekingIterator implements Iterator<Integer> {
        private List<Integer> list;
        private int currentIndex;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.currentIndex = 0;
            this.list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(currentIndex);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(currentIndex++);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }
    }
}


