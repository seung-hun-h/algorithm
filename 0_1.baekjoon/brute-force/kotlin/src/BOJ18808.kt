private var N = 0
private var M = 0
private var K = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    K = k

    val laptop = Array(N) { IntArray(M) { 0 } }
    repeat(k) {
        val(r, c) = readLine().split(" ").map { it.toInt() }
        var sticker = Array(r) { readLine().split(" ").map { it.toInt() }.toIntArray() }

        for (i in 0 until 4) {
            if (attachTo(sticker, laptop)) {
                break
            }
            sticker = rotate(sticker)

        }
    }

    print(countAttachedBlocks(laptop))
}

private fun rotate(sticker: Array<IntArray>): Array<IntArray> {
    val n = sticker.size
    val m = sticker[0].size

    val temp = Array(m) {IntArray(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            temp[j][n - i - 1] = sticker[i][j]
        }
    }

    return temp
}

private fun attachTo(sticker: Array<IntArray>, laptop: Array<IntArray>): Boolean {
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (isAttachableTo(i, j, sticker, laptop)) {
                attachTo(i, j, sticker, laptop)
                return true
            }
        }
    }
    return false
}

private fun isAttachableTo(row: Int, col: Int, sticker: Array<IntArray>, laptop: Array<IntArray>): Boolean {

    val n = sticker.size
    val m = sticker[0].size

    if (row + n > N || col + m > M) {
        return false
    }

    for (i in row until row + n) {
        for (j in col until col + m) {
            if (sticker[i - row][j - col] == 1 && laptop[i][j] == 1) {
                return false
            }
        }
    }

    return true
}

private fun attachTo(row: Int, col: Int, sticker: Array<IntArray>, laptop: Array<IntArray>) {
    val n = sticker.size
    val m = sticker[0].size

    for (i in row until row + n) {
        for (j in col until col + m) {
            if (sticker[i - row][j - col] == 1) {
                laptop[i][j] = 1
            }
        }
    }
}

private fun countAttachedBlocks(laptop: Array<IntArray>): Int {
    var count = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (laptop[i][j] == 1) {
                count++
            }
        }
    }
    return count
}
