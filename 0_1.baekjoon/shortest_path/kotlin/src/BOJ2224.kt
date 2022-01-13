private const val BASE: Int = 'A'.code
private const val SIZE: Int = 'z'.code - BASE + 1
private lateinit var connected: Array<BooleanArray>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    connected = Array(SIZE) { BooleanArray(SIZE) }

    repeat(n) {
        val line = readLine()
        val p = line[0].code - BASE
        val q = line[5].code - BASE

        connected[p][q] = true
    }

    println(solve())
}

private fun solve(): String {
    connect()

    val sb = StringBuilder()
    var count = 0
    for (i in 0 until SIZE) {
        for (j in 0 until SIZE) {
            if (i == j || !connected[i][j]) continue
            val p = (BASE + i).toChar()
            val q = (BASE + j).toChar()
            sb.append(p).append(" => ").append(q).append("\n")
            count++
        }
    }
    sb.insert(0, count.toString() + "\n")
    return sb.toString()
}

private fun connect() {
    for (r in 0 until SIZE) {
        for (p in 0 until SIZE) {
            for (q in 0 until SIZE) {
                if (p == q || connected[p][q]) continue
                connected[p][q] = connected[p][r] && connected[r][q]
            }
        }
    }
}
