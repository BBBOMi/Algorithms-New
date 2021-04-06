package me.algo.week48.sun

/**
 * Created by Bomi on 2021/04/06.
 * 문제 출처 : https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * Time Complexity : O(1)
 * Used Algorithm : Implementation
 * Used Data structure : List(ArrayList)
 */

class Codec() {
    // Encodes a URL to a shortened URL.
    private val urls = mutableListOf<String>()

    fun encode(longUrl: String): String {
        urls.add(longUrl)
        return "${urls.size - 1}"
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return urls[shortUrl.toInt()]
    }
}