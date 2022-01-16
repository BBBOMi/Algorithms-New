package me.algo.week70

/**
 * Created by Bomi on 2022/01/16.
 * 문제 출처 : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Bruteforce
 * Used Data structure : Queue(LinkedList)
 */

class Leet1752 {
    fun check(nums: IntArray): Boolean {
      val queue: Queue<Int> = nums.toCollection(LinkedList<Int>())
      nums.sort()

      var count = nums.size
      while (count >= 0) {
        if (isSame(nums, queue)) break

        count--
        queue.offer(queue.poll())
      }
      return count >= 0
  }

  private fun isSame(ints: IntArray, queue: Queue<Int>): Boolean {
    queue.forEachIndexed { index, it ->
        if (ints[index] != it) return false
    }
    return true
  }
}
