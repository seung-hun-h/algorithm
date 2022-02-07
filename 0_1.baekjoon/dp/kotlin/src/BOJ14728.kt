import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, t) = readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(t + 1)}
    val times = IntArray(n + 1)
    val scores = IntArray(n + 1)

    for (i in 1..n) {
        val (k, s) = readLine().split(" ").map { it.toInt() }
        times[i] = k
        scores[i] = s
    }

    for (i in 1..n) {
        for (j in 1..t) {
            if (j - times[i] < 0) {
                dp[i][j] = dp[i-1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - times[i]] + scores[i])

            }
        }
    }

    println(dp[n][t])

}