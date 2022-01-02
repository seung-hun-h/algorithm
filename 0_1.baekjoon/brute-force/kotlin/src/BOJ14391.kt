import kotlin.math.max

private var N = 0
private var M = 0

private lateinit var board: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    N = n
    M = m

    board = Array(n) {
        readLine()!!.toCharArray().map { Character.getNumericValue(it) }.toIntArray()
    }

    print(dfs(0, 0))
}

private fun dfs(idx: Int, check: Int): Int {
    if (idx == N * M) {
        return getScore(check)
    }

    var result = dfs(idx + 1, check or (1 shl idx))
    result = max(result, dfs(idx + 1, check))

    return result
}

private fun getScore(check: Int): Int {
    var total = 0

    for (i in 0 until N) {
        var horizon = 0
        for (j in 0 until M) {
            if ((check and (1 shl i * M + j)) != 0) {
                horizon *= 10
                horizon += board[i][j]
            } else {
                total += horizon
                horizon = 0
            }
        }

        total += horizon
    }


    for (j in 0 until M) {
        var vertical = 0
        for (i in 0 until N) {
            if ((check and (1 shl i * M + j)) == 0) {
                vertical *= 10
                vertical += board[i][j]
            } else {
                total += vertical
                vertical = 0
            }
        }

        total += vertical
    }

    return total
}
