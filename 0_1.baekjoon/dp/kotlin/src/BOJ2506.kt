import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val spend = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        val line = readLine().split(" ").map { it.toInt() }

        for (j in 0 until line[1]) {
            val parent = line[2 + j]
            spend[i] = max(spend[i], spend[parent])
        }
        spend[i] += line[0]
    }

    print(spend.maxOrNull())
}
