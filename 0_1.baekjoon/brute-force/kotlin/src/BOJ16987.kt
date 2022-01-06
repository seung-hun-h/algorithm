import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val life = IntArray(n)
    val weight = IntArray(n)

    for (i in 0 until n) {
        readLine().split(" ").map { it.toInt() }.also {
            life[i] = it[0]
            weight[i] = it[1]
        }
    }

    fun countBrokenEggs(): Int {
        var count = 0
        life.forEach { n -> if (n <= 0) count++ }
        return count
    }


    fun dfs(hold: Int): Int {
        if (hold == n) {
            return countBrokenEggs()
        }

        if (life[hold] <= 0) {
            return dfs(hold + 1)
        }

        var result = -1

        for (i in 0 until n) {
            if (life[i] <= 0 || i == hold) continue

            life[i] -= weight[hold]
            life[hold] -= weight[i]

            result = max(result, dfs(hold + 1))

            life[i] += weight[hold]
            life[hold] += weight[i]
        }

        if (result == -1) {
            result = max(result, dfs(hold + 1))
        }

        return result
    }

    print(dfs(0))
}