import java.util.*

private val N = 8
private val d = arrayOf(
    arrayOf(-1, -1),
    arrayOf(-1, 0),
    arrayOf(-1, 1),
    arrayOf(1, -1),
    arrayOf(1, 0),
    arrayOf(1, 1),
    arrayOf(0, -1),
    arrayOf(0, 0),
    arrayOf(0, 1),
)


fun main() = with(System.`in`.bufferedReader()) {
    val walls = mutableListOf<Array<Int>>()

    for (i in 0 until N) {
        val line = readLine().trim()
        for (j in 0 until N) {
            if (line[j] == '#') {
                walls.add(arrayOf(i, j))
            }
        }
    }

    println(solve(walls))
}

private fun solve(walls: MutableList<Array<Int>>): Int {
    return if (bfs(walls)) 1 else 0
}

private fun bfs(walls: MutableList<Array<Int>>): Boolean {
    val q: Queue<Array<Int>> = LinkedList()
    q.add(arrayOf(7, 0))

    while (q.isNotEmpty()) {
        val visited = Array(N){Array(N){ false} }
        val size = q.size
        for (k in 0 until size) {
            val(row, col) = q.poll()

            if (!check(row, col, walls))
                continue

            if (row == 0 && col == 7)
                return true

            if (walls.isEmpty())
                return true

            for (i in d.indices) {
                val nr = row + d[i][0]
                val nc = col + d[i][1]

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue
                if (visited[nr][nc]) continue
                if (!check(nr, nc, walls)) continue

                visited[nr][nc] = true
                q.add(arrayOf(nr, nc))
            }
        }

        move(walls)
    }

    return false
}

private fun check(row: Int, col: Int, walls: MutableList<Array<Int>>): Boolean {
    for (wall in walls) {
        if (row == wall[0] && col == wall[1]) {
            return false
        }
    }
    return true
}

private fun move(walls: MutableList<Array<Int>>) {
    val iterator = walls.iterator()
    while (iterator.hasNext()) {
        val wall = iterator.next()
        if (wall[0] + 1 < N) {
            wall[0]++
        } else {
            iterator.remove()
        }
    }
}