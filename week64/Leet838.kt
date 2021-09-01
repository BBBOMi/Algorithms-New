package me.algo.week64

/**
 * Created by Bomi on 2021/09/01.
 * 문제 출처 :https://leetcode.com/problems/push-dominoes/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointer
 * Used Data structure : Array
 */

class Leet838 {
    fun pushDominoes(dominoes: String): String {
        val answer = dominoes.toCharArray()
        var left = -1
        var right = -1
        for (i in 0..dominoes.length) {
            if (i == dominoes.length || answer[i] == RIGHT) {
                if (left < right) { // L...R
                    while (right < i) { // R...R
                        answer[right++] = RIGHT
                    }
                }
                right = i
            } else if (answer[i] == LEFT) {
                if (left > right || right == -1) { // R...L
                    while (++left < i) { // L...L
                        answer[left] = LEFT
                    }
                } else { // R...L
                    left = i
                    var low = right + 1
                    var high = left - 1
                    while (low < high) {
                        answer[low++] = RIGHT
                        answer[high--] = LEFT
                    }
                }
            }
        }
        return String(answer)
    }

    private fun test(dominoes: String): String {
        val answer = dominoes.toCharArray()
        var left = -1
        var right = -1

        for (i in 0..dominoes.length) {
            if (i == dominoes.length || answer[i] == RIGHT) {
                if (left < right) { // L...R
                    while (++right < i) { // R...R
                        answer[right] = RIGHT
                    }
                }
                right = i
            } else if (answer[i] == LEFT) {
                if (right < left || right == -1) { //  R...L...L || ...L
                    while (left < i) { // L...L
                        answer[++left] = LEFT
                    }
                } else { // L...R...L
                    left = i
                    var low = right
                    var high = left
                    while (++low < --high) {
                        answer[low] = RIGHT
                        answer[high] = LEFT
                    }
                }
            }
        }
        return String(answer)
    }

    companion object {
        private const val LEFT = 'L'
        private const val RIGHT = 'R'
    }
}