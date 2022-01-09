import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) {
        readLine().split(" ").map { it.toInt() }
    }
    val pieces = arrayOf(
        arrayOf(arrayOf(2, 1),
                arrayOf(1, 0)),
        arrayOf(arrayOf(1, 2),
                arrayOf(0, 1)),
        arrayOf(arrayOf(0, 1),
                arrayOf(1, 2)),
        arrayOf(arrayOf(1, 0),
                arrayOf(2, 1)))

    var answer = 0

    val visited = Array(n){
        Array(m){ false}
    }

    fun checkRange(row: Int, col: Int): Boolean {
        return row < n && col < m
    }

    fun check(row: Int, col: Int, piece: Array<Array<Int>>, visited: Array<Array<Boolean>>): Boolean {

        for (i in row until row + 2) {
            for (j in col until col + 2) {
                if (piece[i - row][j - col] == 0) continue
                if (!checkRange(i, j)) return false
                if (visited[i][j]) return false
            }
        }

        return true
    }

    fun fill(
        visited: Array<Array<Boolean>>,
        value: Boolean,
        row: Int,
        col: Int,
        piece: Array<Array<Int>>
    ) {
        for (i in row until row + 2) {
            for (j in col until col + 2) {
                if (piece[i - row][j - col] == 0) continue
                visited[i][j] = value
            }
        }
    }

    fun calcSolidity(row: Int, col: Int, piece: Array<Array<Int>>): Int {
        var result = 0
        for (i in row until row + 2) {
            for (j in col until col + 2) {
                result += (piece[i - row][j - col] * board[i][j])
            }
        }

        return  result
    }
    fun dfs(idx: Int, visited: Array<Array<Boolean>>, result: Int) {
        if (idx == n*m) {
            answer = max(answer, result)
            return
        }

        dfs(idx + 1, visited, result)

        val row = idx / m
        val col = idx % m

        for (piece in pieces) {
            if (!check(row, col, piece, visited)) continue
            fill(visited, true, row, col, piece)
            val s = calcSolidity(row, col, piece)
            dfs(idx + 1, visited, result + s)
            fill(visited, false, row, col, piece)
        }
    }

    dfs(0, visited, 0)
    print(answer)
}