import java.util.*
import kotlin.Comparator
import kotlin.math.pow
import kotlin.math.sqrt

private var N = 0
private var M = 0
private var W = 0.0
private lateinit var connected: Array<BooleanArray>
private lateinit var pointMap: MutableMap<Int, Pair<Int, Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    W = readLine().toDouble()
    pointMap = mutableMapOf()
    connected = Array(N + 1) { BooleanArray(N + 1) }
    for (i in 1..N) {
        val (row, col) = readLine().split(" ").map { it.toInt() }
        pointMap[i] = Pair(row, col)
    }

    repeat(M) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        connected[u][v] = true
        connected[v][u] = true
    }

    print(solve())
}

private fun solve(): Int {
    var result = getMinWireLength(1)

    return (result * 1000).toInt()
}

private fun getMinWireLength(start: Int): Double {
    val dist = DoubleArray(N + 1)
    val compareByWire: Comparator<Pair<Int, Double>> = compareBy { it.second }
    val pq = PriorityQueue(compareByWire)

    Arrays.fill(dist, Double.MAX_VALUE)
    dist[start] = 0.0
    pq.add(Pair(start, 0.0))

    while (pq.isNotEmpty()) {
        val (node, wire) = pq.poll()

        if (wire > dist[node]) continue

        for (adj in 1..N) {
            if (adj == node) continue
            var alt = wire

            if (!connected[node][adj]) {
                alt += getDist(node, adj)
            }

            if (dist[adj] > alt) {
                dist[adj] = alt
                pq.add(Pair(adj, alt))
            }
        }
    }

    return dist[N]
}

private fun getDist(node1: Int, node2: Int): Double {
    val (r1, c1) = pointMap[node1]!!
    val (r2, c2) = pointMap[node2]!!
    return sqrt((r1 - r2).toDouble().pow(2) + (c1 - c2).toDouble().pow(2))
}