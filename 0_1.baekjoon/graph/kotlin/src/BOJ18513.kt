import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt()}
    val set = readLine().split(" ").map { it.toInt() }.toMutableSet()

    solve(n, k, set)
}

private var N = 0
private var K = 0
private fun solve(n: Int, k: Int, set: MutableSet<Int>) {
    N = n;
    K = k;
    println(bfs(set))
}
private fun bfs(set: MutableSet<Int>): Long {
    val q: Queue<Array<Int>> = LinkedList()
    var count = 0
    var result = 0L

    set.forEach { q.add(arrayOf(it, 0)) }

    while (q.isNotEmpty()) {
        val (place, value) = q.poll()

        for (i in arrayOf(1, -1)) {
            val np = place + i

            if (set.contains(np)) continue

            set.add(np)
            q.add(arrayOf(np, value + 1))
            count++
            result += (value + 1)

            if (count == K) {
                return result
            }
        }
    }

    return -1
}