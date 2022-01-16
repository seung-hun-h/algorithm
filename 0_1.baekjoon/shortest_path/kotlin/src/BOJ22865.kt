import java.util.*
import kotlin.math.min

private const val INF = 9999999999L
private var N = 0
private lateinit var graph: MutableMap<Int, MutableList<Pair<Int, Int>>>
private lateinit var distMap: MutableMap<Int, LongArray>

fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    distMap = mutableMapOf()
    readLine().split(" ").map { it.toInt() }.forEach {
        distMap[it] = LongArray(N + 1) { INF}
    }

    val M = readLine().toInt()
    graph = mutableMapOf()
    repeat(M) {
        val (u, v, w) = readLine().split(" ").map { it.toInt() }

        graph.putIfAbsent(u, mutableListOf())
        graph.putIfAbsent(v, mutableListOf())

        graph[u]!!.add(Pair(v, w))
        graph[v]!!.add(Pair(u, w))
    }

    print(solve())
}

private fun solve(): Int {
    for (key in distMap.keys) {
        dijkstra(key, distMap[key]!!)
    }

    var answer = Pair(0L, 0)
    for (i in 1..N) {
        var minLength = INF
        for (key in distMap.keys) {
            minLength = min(minLength, distMap[key]!![i])
        }

        if (answer.first < minLength) {
            answer = Pair(minLength, i)
        }
    }

    return answer.second
}

private fun dijkstra(start: Int, dist: LongArray) {
    val compareBy: Comparator<Pair<Int, Long>> = compareBy { it.second }
    val pq = PriorityQueue(compareBy)

    dist[start] = 0L
    pq.add(Pair(start, 0L))

    while (pq.isNotEmpty()) {
        val (node, weight) = pq.poll()

        if (weight > dist[node]) {
            continue
        }

        for ((adj, w) in graph.getOrDefault(node, mutableListOf())) {
            val alt = weight + w

            if (dist[adj] > alt) {
                dist[adj] = alt
                pq.add(Pair(adj, alt))
            }
        }
    }
}