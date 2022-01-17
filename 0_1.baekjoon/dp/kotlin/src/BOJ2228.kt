import kotlin.math.max

private const val INF = -32768 * 101
private lateinit var dp: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var ps: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    ps = IntArray(n + 1) { 0}

    for (i in 1..n) {
        ps[i] = ps[i - 1] + readLine().toInt()
    }

    dp = Array(n + 1) { IntArray(m + 1) { INF} }
    visited = Array(n + 1) { BooleanArray(m + 1) { false} }

    print(dfs(n, m))
}

private fun dfs(idx: Int, section: Int): Int {
    if (section == 0) return 0
    if (idx < 0) return INF
    if (visited[idx][section]) return dp[idx][section]

    visited[idx][section] = true
    dp[idx][section] = dfs(idx - 1, section)

    for (i in idx downTo 1) {
        dp[idx][section] = max(dp[idx][section], ps[idx] - ps[i - 1] + dfs(i - 2, section - 1))
    }

    return dp[idx][section]
}