import java.util.*
import kotlin.collections.HashMap

private var N = 0
private var M = 0
private lateinit var graph: HashMap<Int, MutableList<Int>>
private lateinit var path: BooleanArray
private lateinit var parent: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt()}
    N = n
    M = m

    graph = HashMap()
    path = BooleanArray(N + 1)
    parent = IntArray(N + 1)

    for (i in 0..N) {
        parent[i] = i
    }

    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph.putIfAbsent(u, mutableListOf())
        graph.putIfAbsent(v, mutableListOf())

        graph[u]!!.add(v)
        graph[v]!!.add(u)
    }

    for (key in graph.keys) {
        graph[key]!!.sort()
    }

    val (s, e) = readLine().split(" ").map { it.toInt() }

    print(solve(s, e))
}

private fun solve(s: Int, e: Int): Int {
    var result = bfs(s, e)
    checkPath(e)
    return result + bfs(e, s)
}

private fun checkPath(node: Int) {
    var node = node
    while(parent[node] != node) {
        path[node] = true
        node = parent[node]
    }
}

private fun bfs(s: Int, e: Int): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = BooleanArray(N + 1)
    q.add(Pair(s, 0))
    visited[s] = true

    while (q.isNotEmpty()) {
        val (node, length) = q.poll()

        for (adj in graph.getOrDefault(node, mutableListOf())) {
            if (visited[adj] || path[adj]) continue
            parent[adj] = node
            if (adj == e) {
                return length + 1
            }

            visited[adj] = true
            q.add(Pair(adj, length + 1))
        }
    }

    return -1
}