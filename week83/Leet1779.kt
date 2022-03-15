package me.algo.week83

import kotlin.math.abs

/**
 * Created by Bomi on 2022/03/15.
 * 문제 출처 : https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array, Map(LinkedHashMap)
 */

class Leet1779 {
    private companion object {
        const val COORDINATE_X = 0
        const val COORDINATE_Y = 1

        const val NOT_EXIST_VALUE = -1
    }

    inner class COORDINATE(
        val index: Int = -1,
        val x: Int,
        val y: Int
    )

    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        return mutableMapOf<Int, Pair<Int, Int>>().apply { // (index, (coordinateX, coordinateY)
            points.forEachIndexed { index, coordinate ->
                if (coordinate[COORDINATE_X] == x || coordinate[COORDINATE_Y] == y) {
                    this[index] = coordinate[COORDINATE_X] to coordinate[COORDINATE_Y]
                }
            }
        }.minBy { (_, coordinate) ->
            abs(x - coordinate.first) + abs(y - coordinate.second) // Manhattan distance
        }?.key ?: NOT_EXIST_VALUE
    }
}