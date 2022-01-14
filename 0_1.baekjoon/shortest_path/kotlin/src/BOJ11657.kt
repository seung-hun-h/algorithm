import java.util.*

private const val INF = 9999999999L
private var N = 0
private var M = 0
private lateinit var graph: MutableList<Edge>
private lateinit var dist: LongArray

data class Edge(val from: Int, val to: Int, val weight: Long)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    graph = mutableListOf()
    dist = LongArray(N + 1)
    repeat(M) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        graph.add(Edge(from, to, weight.toLong()))
    }

    print(solve())
}

private fun solve(): String {
    if (hasNegativeCycle(1)) {
        return "-1"
    }
    val sb = StringBuilder()
    for (i in 2..N) {
        if (dist[i] == INF) {
            sb.append(-1)
        } else {
            sb.append(dist[i])
        }
        sb.append("\n")
    }
    return sb.toString()
}

fun hasNegativeCycle(start: Int): Boolean {
    return bellmanFord(start)
}

fun bellmanFord(start: Int): Boolean {
    Arrays.fill(dist, INF)
    dist[start] = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            val edge = graph[j]
            if (dist[edge.from] == INF) continue
            if (dist[edge.to] > dist[edge.from] + edge.weight) {
                dist[edge.to] = dist[edge.from] + edge.weight

                if (i == N - 1) {
                    return true
                }
            }
        }
    }
    return false
}
