private val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    dfs(IntArray(m), 0, n, m)
    print(sb.toString())
}

private fun dfs(result: IntArray, depth: Int, n: Int, m: Int) {
    if (depth == m) {
        result.forEach { r -> sb.append(r).append(" ") }
        sb.append("\n")
        return
    }

    for (i in 1..n) {
        result[depth] = i
        dfs(result, depth + 1, n, m)
    }
}