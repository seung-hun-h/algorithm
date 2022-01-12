import java.util.*

private var N = 0
private var M = 0
private var H = 0
private var W = 0

private lateinit var ps: Array<Array<Int>>
private val d = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
fun main() = with(System.`in`.bufferedReader()) {
    val(n, m) = readLine().split(" ").map{ it.toInt()}
    ps = Array(n + 1) {Array(m +  1) { 0} }
    N = n
    M = m

    for (i in 1 until n + 1) {
        val st = StringTokenizer(readLine())
        for (j in 1 until m + 1) {
            ps[i][j] = ps[i - 1][j] + ps[i][j - 1] + st.nextToken().toInt() - ps[i - 1][j - 1]
        }
    }

    val st = StringTokenizer(readLine())
    H = st.nextToken().toInt()
    W = st.nextToken().toInt()
    val sr = st.nextToken().toInt()
    val sc = st.nextToken().toInt()
    val fr = st.nextToken().toInt()
    val fc = st.nextToken().toInt()

    print(solve(sr, sc, fr, fc))
}

private fun solve(sr: Int, sc: Int, fr: Int, fc: Int): Int {
    return bfs(sr, sc, fr, fc)
}

private fun bfs(sr: Int, sc: Int, fr: Int, fc: Int): Int {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    val visited = Array(N + 1){ BooleanArray(M + 1)}

    q.add(Triple(sr, sc, 0))
    visited[sr][sc] = true
    while (q.isNotEmpty()) {
        val (row, col, count) = q.poll()

        if (row == fr && col == fc) {
            return count
        }

        for (i in 0 until 4) {
            val nr = row + d[i][0]
            val nc = col + d[i][1]
            val er = nr + H - 1
            val ec = nc + W - 1

            if (!checkRange(nr, nc) || !checkRange(er, ec)) continue
            if (!checkWall(nr, nc, er, ec)) continue
            if (visited[nr][nc]) continue

            visited[nr][nc] = true
            q.add(Triple(nr, nc, count + 1))
        }
    }
    return -1
}

private fun checkRange(row: Int, col: Int): Boolean {
    return row in 1 until N + 1 && col in 1 until M + 1
}

private fun checkWall(sr: Int, sc: Int, er: Int, ec: Int): Boolean {
    val sum = ps[er][ec] - ps[sr-1][ec] - ps[er][sc-1] + ps[sr-1][sc-1]

    return sum == 0
}