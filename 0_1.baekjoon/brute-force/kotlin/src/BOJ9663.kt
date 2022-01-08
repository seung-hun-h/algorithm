import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val column = IntArray(n) { 0}

    var answer = 0

    fun check(row: Int, col: Int): Boolean {
        for (i in 0 until row) {
            if (col == column[i]) {
                return false
            }

            if ((row - i) == abs(col - column[i])) {
                return false
            }
        }
        return true
    }

    fun dfs(depth: Int) {
        if (depth == n) {
            answer++
            return
        }

        for (i in 0 until n) {
            if (check(depth, i)) {
                column[depth] = i
                dfs(depth + 1)
                column[depth] = 0
            }
        }
    }
    dfs(0)

    print(answer)

}