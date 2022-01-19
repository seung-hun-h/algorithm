import kotlin.math.min

private const val INF = 200000001
private var N = 0
private var M = 0
private val d = arrayOf(-1, 0, 1)
private lateinit var dp: Array<Array<IntArray>>
private lateinit var arr: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n + 1
    M = m
    dp = Array(N){Array(M){ IntArray(3) { INF} } }
    arr = Array(N) { IntArray(M) }
    for (i in 1 until N) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in 0 until M) {
        for (j in 0 until 3) {
            dp[0][i][j] = arr[0][i]
        }
    }
    var answer = INF
    for (i in 0 until M) {
        for (j in 0 until 3) {
            answer = min(answer, dfs(N - 1, i, j))
        }
    }
    print(answer)
}

private fun dfs(row: Int, col: Int, dir: Int): Int {
    if (dp[row][col][dir] != INF) {
        return dp[row][col][dir]
    }

    for (i in 0 until 3) {
        if (i == dir) continue
        val (nr, nc) = arrayOf(row - 1, col + d[i])
        if (nr !in 0 until N || nc !in 0 until M) continue
        dp[row][col][dir] = min(dp[row][col][dir], dfs(nr, nc, i) + arr[row][col])
    }

    return dp[row][col][dir]
}