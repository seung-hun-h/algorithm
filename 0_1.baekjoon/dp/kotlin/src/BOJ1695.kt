import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val reverse = arr.reversed()
    val dp = Array(n + 1) { IntArray(n + 1)}
    for (s in 1..n) {
        for (e in 1 .. n) {
            if (arr[s - 1] == reverse[e - 1]) {
                dp[s][e] = dp[s - 1][e - 1] + 1
            } else {
                dp[s][e] = max(dp[s - 1][e], dp[s][e - 1])
            }
        }
    }
    print(n - dp[n][n])
}