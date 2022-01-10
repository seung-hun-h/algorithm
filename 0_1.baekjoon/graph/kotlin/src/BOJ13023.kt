private var N = 0
private var M = 0
private lateinit var graph: HashMap<Int, MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val(n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    graph = HashMap()

    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt()}
        graph.putIfAbsent(u, mutableListOf())
        graph.putIfAbsent(v, mutableListOf())

        graph[u]!!.add(v)
        graph[v]!!.add(u)
    }

    print(solve())
}

private fun solve(): Int {
    for (i in 0 until N) {
        var visited = BooleanArray(N) { false}
        visited[i] = true
        if(dfs(i, visited, 1)) {
            return 1
        }
    }
    return 0
}

private fun dfs(node: Int, visited: BooleanArray, depth: Int): Boolean {
    if (depth == 5) {
        return true
    }

    for (adj in graph.getOrDefault(node, mutableListOf())) {
        if (visited[adj]) continue
        visited[adj] = true
        if(dfs(adj, visited, depth + 1)) {
            return true
        }
        visited[adj] = false
    }
    return false
}