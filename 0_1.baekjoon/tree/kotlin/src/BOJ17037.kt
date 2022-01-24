fun main() = with(System.`in`.bufferedReader()) {
    val (n, w) = readLine().split(" ").map { it.toInt() }
    val degree = Array(n + 1) { 0 }

    repeat(n - 1) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        degree[u]++
        degree[v]++
    }

    var leaf = 0
    for (i in 2..n) {
        if (degree[i] == 1) {
            leaf++
        }
    }

    print(w / leaf.toDouble())
}