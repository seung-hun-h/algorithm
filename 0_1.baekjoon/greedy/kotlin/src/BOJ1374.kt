import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val lectures = List(n) { readLine().split(" ").map { it.toInt() } }.sortedBy { it[1] }

    val pq = PriorityQueue<Int>()

    var answer = 0

    for (i in 0 until n) {

        while (!pq.isEmpty() && pq.peek() <= lectures[i][1]) {
            pq.poll()
        }

        pq.add(lectures[i][2])
        answer = max(answer, pq.size)
    }

    print(answer)

}