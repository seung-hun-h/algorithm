import java.util.*
import kotlin.math.min

private const val INF = 50000001

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val dist = Array(v + 1) { IntArray(v + 1) { INF} }

    for (i in 1..v) {
        Arrays.fill(dist[i], INF)
    }

    repeat(e) {
        val(from, to, weight) = readLine().split(" ").map { it.toInt() }
        dist[from][to] = weight
    }

    for (k in 1..v) {
        for (i in 1..v) {
            if (i == k) continue
            for (j in 1..v) {

                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    var answer = INF
    for (i in 1..v) {
        answer = min(answer, dist[i][i])
    }

    print(if (answer == INF) -1 else answer)
}