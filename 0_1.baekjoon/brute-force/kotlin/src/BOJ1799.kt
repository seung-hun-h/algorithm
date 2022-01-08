import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val BLACK = 0
    val WHITE = 1
    val BISHOP = 2
    val d = arrayOf(arrayOf(1, 1), arrayOf(1, -1), arrayOf(-1, 1), arrayOf(-1, -1))

    val answer = IntArray(2)
    val n = readLine().toInt()
    val board = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val colors = Array(n) {IntArray(n){ 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i % 2 == 0) {
                if (j % 2 == 0) {
                    colors[i][j] = BLACK
                } else {
                    colors[i][j] = WHITE
                }
            } else {
                if (j % 2 == 0) {
                    colors[i][j] = WHITE
                } else {
                    colors[i][j] = BLACK
                }
            }
        }
    }

    fun checkRange(row: Int, col: Int, height: Int, width: Int): Boolean {
        return row in 0 until height && col in 0 until width
    }

    fun check(row: Int, col: Int): Boolean {
        for (i in 0 until 4) {
            var nr = row
            var nc = col
            while (checkRange(nr, nc, n, n)) {
                if (board[nr][nc] == BISHOP) {
                    return false
                }

                nr += d[i][0]
                nc += d[i][1]
            }
        }
        return true
    }

    fun go(idx: Int, count: Int, color: Int) {
        answer[color] = max(answer[color], count)

        for (i in idx + 1 until (n * n)) {
            val row = i / n
            val col = i % n

            if (board[row][col] != 1) continue
            if (colors[row][col] != color) continue

            go(i, count, color)
            if (check(row, col)) {
                board[row][col] = BISHOP
                go(i, count + 1, color)
                board[row][col] = 1
            }
            break
        }
    }

    fun solve():Int {
        go(-1, 0, BLACK)
        go(-1, 0, WHITE)

        return answer[BLACK] + answer[WHITE]
    }

    print(solve())
}