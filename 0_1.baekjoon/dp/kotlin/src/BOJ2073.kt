import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (d, p) = readLine().split(" ").map { it.toInt() }

    val dp = IntArray(d + 1)
    val pipes = Array(p) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0] = Int.MAX_VALUE

    for (i in 0 until p) {
        val (l, c) = pipes[i]
        for (j in d downTo 0) {

            if (j - l < 0) continue
            dp[j] = max(dp[j], min(dp[j - l], c))
        }
    }

    print(dp[d])
}

