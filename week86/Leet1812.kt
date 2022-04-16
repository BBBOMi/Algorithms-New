package me.algo.week86

/**
 * Created by Bomi on 2022/04/16.
 * 문제 출처 : https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 *
 * Time Complexity : O(1)
 * Used Algorithm : String
 * Used Data structure : Array
 */

class Leet1812 {
    companion object {
        private const val CHAR_INDEX = 0
        private const val INT_INDEX = 1
    }

    // 홀짝 조합 = 화이트
    fun squareIsWhite(coordinates: String): Boolean {
        return (coordinates[CHAR_INDEX].isEven() && coordinates[INT_INDEX].toInt().isOdd())
                || (coordinates[CHAR_INDEX].isOdd() && coordinates[INT_INDEX].toInt().isEven())
    }

    private fun Char.isEven() = this.toInt().isEven()
    private fun Int.isEven() = this % 2 == 0

    private fun Char.isOdd() = !this.isEven()
    private fun Int.isOdd() = !this.isEven()
}
