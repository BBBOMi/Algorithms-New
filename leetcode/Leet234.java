package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : List(ArrayList)
 */

public class Leet234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int leftIndex = 0, rightIndex = values.size() - 1;
        while (leftIndex <= rightIndex) {
            if (!values.get(leftIndex).equals(values.get(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
