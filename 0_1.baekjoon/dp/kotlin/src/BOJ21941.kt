import kotlin.math.max

private lateinit var dp: IntArray
private lateinit var wordMap: MutableMap<String, Int>
private var s = ""
fun main() = with(System.`in`.bufferedReader()) {
    s = readLine()
    wordMap = mutableMapOf<String, Int>()
    repeat(readLine().toInt()) {
        val (word, value) = readLine().split(" ")
        wordMap[word] = value.toInt()
    }
    dp = IntArray(s.length + 1)
    print(dfs(s.length, 0))
}

private fun dfs(limit: Int, idx: Int): Int {
    if (idx >= limit) {
        return 0
    }

    if (dp[idx] != 0) {
        return dp[idx]
    }

    wordMap.keys.forEach {
        val size = it.length
        if (s.startsWith(it, idx)) {
            dp[idx] = max(dp[idx], dfs(limit, idx + size) + wordMap[it]!!)
        }
    }
    dp[idx] = max(dp[idx], dfs(limit, idx + 1) + 1)

    return dp[idx]
}