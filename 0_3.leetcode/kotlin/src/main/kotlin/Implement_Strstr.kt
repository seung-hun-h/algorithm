fun strStr(haystack: String, needle: String): Int {
    val h = haystack.length
    val n = needle.length
    var hIdx = 0
    var nIdx = 0

    while (hIdx < h && nIdx < n) {
        if (haystack[hIdx] == needle[nIdx]) {
            nIdx++
        } else {
            hIdx -= nIdx
            nIdx = 0
        }
        hIdx++
    }

    return if (nIdx == n) {
        hIdx - n
    } else {
        -1
    }
}