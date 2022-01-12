import java.util.*
import kotlin.collections.HashSet
import kotlin.math.max

private var N = 0
private var M = 0
private lateinit var board: Array<IntArray>
private lateinit var group: Array<IntArray>
private lateinit var size: IntArray
private val d = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    board = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    group = Array(n) { IntArray(m) }
    size = IntArray(n * m + 1)
    print(solve())
}

private fun solve(): Int {
    grouping()
    var answer = 0
    val set = HashSet<Int>()

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 1) continue
            var result = 1

            if (i - 1 >= 0) {
                result += size[group[i - 1][j]]
                set.add(group[i - 1][j])
            }

            if (i + 1 < N && !set.contains(group[i + 1][j])) {
                result += size[group[i + 1][j]]
                set.add(group[i + 1][j])
            }

            if (j - 1 >= 0 && !set.contains(group[i][j - 1])) {
                result += size[group[i][j - 1]]
                set.add(group[i][j - 1])
            }

            if (j + 1 < M && !set.contains(group[i][j + 1])) {
                result += size[group[i][j + 1]]
            }

            answer = max(answer, result)
            set.clear()
        }
    }

    return answer
}

private fun grouping() {
    val visited = Array(N) { BooleanArray(M)}
    var seq = 1


    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 0 || visited[i][j]) continue
            bfs(i, j, visited, seq++)
        }
    }
}

private fun bfs(row: Int, col: Int, visited: Array<BooleanArray>, seq: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    visited[row][col] = true
    q.add(Pair(row, col))

    while (q.isNotEmpty()) {
        val (r, c) = q.poll()

        size[seq]++
        group[r][c] = seq

        for (i in 0 until 4) {
            val nr = r + d[i][0]
            val nc = c + d[i][1]

            if (!(nr in 0 until N && nc in 0 until M)) continue
            if (visited[nr][nc] || board[nr][nc] == 0) continue
            visited[nr][nc] = true
            q.add(Pair(nr, nc))
        }
    }
}