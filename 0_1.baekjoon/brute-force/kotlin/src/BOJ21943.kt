import kotlin.math.max

var n = 0
var p = 0
var q = 0
lateinit var arr: IntArray
lateinit var ps: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    readLine().split(" ")
        .also { result ->
            p = result[0].toInt()
            q = result[1].toInt()
        }


    ps = IntArray(q + 1) { 0 }

    print(dfs(0))
}

private fun dfs(idx: Int): Int {
    if (idx == n) {
        return getResult()
    }

    var result = 0
    for (i in 0 .. q) {
        ps[i] += arr[idx]
        result = max(result, dfs(idx + 1))
        ps[i] -= arr[idx]
    }

    return result
}

private fun getResult(): Int {
    var result = 1
    for (i in 0 .. q) {
        result *= ps[i]
    }

    return result
}

