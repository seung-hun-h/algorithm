import java.util.*

private val PATH = 0
private val WALL = 1
private val GRAM = 2
private val d = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))

private var N = 0
private var M = 0
private var T = 0
private lateinit var board: Array<Array<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val(n, m, t) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    T = t

    board = Array(n) {
        readLine().split(" ").map { it.toInt() }.toTypedArray()
    }
    val answer = bfs()
    print(if (answer == -1) "Fail" else answer)
}

private fun bfs(): Int {
    val visited = Array(N){Array(M) {Array(2) { false} } }
    val q: Queue<Array<Int>> = LinkedList()

    q.add(arrayOf(0, 0, 0, 0))
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val (row, col, gram, spend) = q.poll()

        if (row == N - 1 && col == M - 1) {
            return if (spend <= T) spend else -1
        }

        for (i in d.indices) {
            val nr = row + d[i][0]
            val nc = col + d[i][1]

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue

            if (visited[nr][nc][gram]) continue

            if (board[nr][nc] == WALL) {
                if (gram == 1) {
                    visited[nr][nc][gram] = true
                    q.add(arrayOf(nr, nc, gram, spend + 1))
                }
            } else if (board[nr][nc] == GRAM) {
                visited[nr][nc][1] = true
                q.add(arrayOf(nr, nc, 1, spend + 1))
            } else {
                visited[nr][nc][gram] = true
                q.add(arrayOf(nr, nc, gram, spend + 1))
            }
        }

    }

    return -1
}
