import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(m + 1)}
    val answer = readLine()
    val result = readLine()

    for (i in 1..n) {
        dp[i][0] = i
    }

    for (i in 1..m) {
        dp[0][i] = i
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (correspond(answer[i - 1], result[j - 1])) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
            }
        }
    }

    print(dp[n][m])
}

fun correspond(input: Char, target: Char): Boolean {
    return input == target || (input == 'i' && (target == 'j' || target == 'l') || (input == 'v' && target == 'w'))
}

private fun min(i: Int, j: Int, k: Int): Int {
    return min(i, min(j, k))
}
