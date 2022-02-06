import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var t = readLine().toInt()

    while (t-- > 0) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val dp = Array(n + 1) { LongArray(m + 1) { 0} }
        Arrays.fill(dp[0], 1)

        for (i in 1..n) {
            for (j in 1..m) {
                dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1]
            }
        }
        println(dp[n][m])
    }
}