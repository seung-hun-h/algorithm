private var N = 0;
private var M = 0;
private var H = 0;

private lateinit var dp: Array<IntArray>
private lateinit var blocks: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }
    N = n;
    M = m;
    H = h;

    dp = Array(N) { IntArray(H + 1) { -1} }
    blocks = Array(N) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until N) {
        dp[i][0] = 1
    }

    print(dfs(0, H))

}

private fun dfs(idx: Int, height: Int): Int {
    if (height == 0) {
        return 1
    }

    if (idx == N || height < 0) {
        return 0
    }

    if (dp[idx][height] != -1) {
        return dp[idx][height]
    }

    dp[idx][height] = dfs(idx + 1, height)
    for (block in blocks[idx]) {
        dp[idx][height] += dfs(idx + 1, height - block)
    }

    dp[idx][height] %= 10007
    return dp[idx][height]
}