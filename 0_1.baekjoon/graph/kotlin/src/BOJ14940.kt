import java.util.*

private var N = 0
private var M = 0
private lateinit var board: Array<Array<Int>>
private var d = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    board = Array(n) {
        readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    var dist = Array(n){ Array(m) { -1 } }

    var row = 0
    var col = 0

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 2) {
               row = i
               col = j
            } else if (board[i][j] == 0) {
                dist[i][j] = 0
            }
        }
    }

    bfs(row, col, dist)
    val st = StringBuilder()
    dist.forEach { it ->
        it.forEach {
            st.append(it).append(" ")
        }
        st.append("\n")
    }

    print(st)
}

fun bfs(row: Int, col: Int, dist: Array<Array<Int>>) {
    val visited = Array(N) {Array(M){ false } }
    val q: Queue<Array<Int>> = LinkedList()

    q.add(arrayOf(row, col, 0))
    visited[row][col] = true

    while (q.isNotEmpty()) {
        val (r, c, s) = q.poll()

        dist[r][c] = s

        for (i in d.indices) {
            val nr = r + d[i][0]
            val nc = c + d[i][1]

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue

            if (visited[nr][nc]) continue

            if (board[nr][nc] == 0) continue

            visited[nr][nc] = true
            q.add(arrayOf(nr, nc, s + 1))
        }
    }
}