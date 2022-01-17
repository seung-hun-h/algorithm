import kotlin.math.max

private lateinit var dp: IntArray
private lateinit var reverseGraph: MutableMap<Int, MutableList<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    dp = IntArray(n + 1)
    reverseGraph = mutableMapOf()

    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        reverseGraph.putIfAbsent(to, mutableListOf())
        reverseGraph[to]!!.add(from)
    }

    val sb = StringBuilder()
    for (i in 1..n) {
        sb.append(dfs(i)).append(" ")
    }

    print(sb)
}

private fun dfs(node: Int): Int {

    if (dp[node] != 0) {
        return dp[node]
    }

    if (!reverseGraph.containsKey(node)) {
        return 1
    }

    var max = 0
    for (before in reverseGraph[node]!!) {
        max = max(max, dfs(before))
    }

    dp[node] = max + 1

    return dp[node]
}