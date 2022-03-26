package me.algo.week85

/**
 * Created by Bomi on 2022/03/26.
 * 문제 출처 : https://leetcode.com/problems/design-authentication-manager/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

class Leet1797 {
    class AuthenticationManager(timeToLive: Int) {
        private val ttl = timeToLive
        private val authentications = HashMap<String, Int>() // (tokenId, endTime)

        fun generate(tokenId: String, currentTime: Int) {
            authentications[tokenId] = currentTime + ttl
        }

        fun renew(tokenId: String, currentTime: Int) {
            val endTime = authentications[tokenId] ?: return
            if (endTime <= currentTime) return

            authentications[tokenId] = currentTime + ttl
        }

        fun countUnexpiredTokens(currentTime: Int): Int {
            return authentications.filter { (_, endTime) -> endTime > currentTime }.count()
        }
    }
}
