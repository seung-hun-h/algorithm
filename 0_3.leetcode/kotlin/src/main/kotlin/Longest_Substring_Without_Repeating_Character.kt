fun main() {
    val answer = lengthOfLongestSubstring("abcabcbb")
    println("answer = $answer")
}

fun lengthOfLongestSubstring(s: String): Int {
    val idxMap = mutableMapOf<Char, Int>()
    var left = 0
    var answer = 0
    s.forEachIndexed { right, ch ->
        idxMap[ch]?.let { left = left.coerceAtLeast(it + 1) }
        answer = answer.coerceAtLeast(right - left + 1)
        idxMap[ch] = right
    }

    return answer
}