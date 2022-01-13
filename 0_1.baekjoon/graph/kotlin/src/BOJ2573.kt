import java.util.*

private var N = 0
private var M = 0
private val d = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
private lateinit var board: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    board = Array(N) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    print(solve())
}

private fun solve(): Int {
    var answer = 0
    while(true) {
        if (divided()) {
            return answer
        }
        if (!melted()) {
            return 0
        }
        answer++
    }
}

private fun divided(): Boolean {
    val visited = Array(N){ BooleanArray(M)}
    var flag = false
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 0 || visited[i][j]) continue
            if (flag) return true
            bfs(i, j, visited)
            flag = true
        }
    }

    return false
}
private fun checkRange(row: Int, col: Int): Boolean { return row in 0 until N && col in 0 until M}
private fun bfs(row: Int, col: Int, visited: Array<BooleanArray>) {

    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(row, col))
    visited[row][col] = true

    while (q.isNotEmpty()) {
        val (r, c) = q.poll()

        for (i in 0 until 4) {
            val nr = r + d[i][0]
            val nc = c + d[i][1]

            if (!checkRange(nr, nc)) continue
            if (visited[nr][nc] || board[nr][nc] == 0) continue
            visited[nr][nc] = true
            q.add(Pair(nr, nc))
        }
    }
}

private fun melted(): Boolean {
    var removed = ArrayList<Triple<Int, Int, Int>>()
    var flag = false
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 0) continue
            var count = 0
            for (k in 0 until 4) {
                val nr = i + d[k][0]
                val nc = j + d[k][1]
                if (!checkRange(nr, nc)) continue
                if (board[nr][nc] == 0) {
                    count++
                    flag = true
                }
            }
            removed.add(Triple(i, j, count))
        }
    }

    for ((row, col, count) in removed) {
        board[row][col] -= count
        if (board[row][col] < 0) {
            board[row][col] = 0
        }
    }

    return flag
}