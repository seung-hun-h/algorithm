fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val n = readLine().toInt()
        val coins = readLine().split(" ").map { it.toInt() }
        val m = readLine().toInt()
        val dp = IntArray(m + 1)
        dp[0] = 1
        for (i in 0 until n) {
            for (j in coins[i]..m) {
                dp[j] += dp[j - coins[i]]
            }
        }
        println(dp[m])
    }
}