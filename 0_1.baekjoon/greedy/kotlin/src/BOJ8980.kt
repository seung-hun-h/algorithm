import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val works =
        List(m) { readLine().split(" ").map { it.toInt() } }
            .sortedWith(
                compareBy(
                    { it[1] },
                    { it[0] })
            )

    val delivery = Array(n + 1) { 0 }
    var answer = 0
    for (i in 0 until m) {
        val work = works[i]
        var max = delivery.slice(work[0]..work[1]).maxOf { d -> d }
        val possible = min(c - max, work[2])
        answer += possible

        for (j in work[0] until work[1]) {
            delivery[j] += possible
        }
    }

    print(answer)
}