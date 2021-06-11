package me.algo.week56.wed

import kotlin.math.min

/**
 * Created by Bomi on 2021/06/11.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/77485
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

class P77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var count = 1
        val matrix = Array(rows) { IntArray(columns) { count++ } }

        val answer = IntArray(queries.size)
        queries.forEachIndexed { index, query ->
            rotation(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1, matrix)
            answer[index] = minOfRange(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1, matrix)
        }
        return answer
    }

    private fun rotation(startX: Int, startY: Int, endX: Int, endY: Int, matrix: Array<IntArray>) {
        // left -> right
        var cachedCurrent = matrix[startX][endY]
        (endY downTo (startY + 1)).forEach {
            matrix[startX][it] = matrix[startX][it - 1]
        }

        // top -> bottom
        var cachedPre = cachedCurrent
        cachedCurrent = matrix[endX][endY]
        (endX downTo (startX + 2)).forEach {
            matrix[it][endY] = matrix[it - 1][endY]
        }
        matrix[startX + 1][endY] = cachedPre

        // right -> left
        cachedPre = cachedCurrent
        cachedCurrent = matrix[endX][startY]
        (startY until (endY - 1)).forEach {
            matrix[endX][it] = matrix[endX][it + 1]
        }
        matrix[endX][endY - 1] = cachedPre

        // bottom -> top
        (startX until (endX - 1)).forEach {
            matrix[it][startY] = matrix[it + 1][startY]
        }
        matrix[endX - 1][startY] = cachedCurrent
    }

    private fun minOfRange(startX: Int, startY: Int, endX: Int, endY: Int, matrix: Array<IntArray>): Int {
        var minValue = Int.MAX_VALUE
        (startX..endX).forEach {
            minValue = min(minValue, matrix[it][startY])
            minValue = min(minValue, matrix[it][endY])
        }

        (startY..endY).forEach {
            minValue = min(minValue, matrix[startX][it])
            minValue = min(minValue, matrix[endX][it])
        }
        return minValue
    }
}