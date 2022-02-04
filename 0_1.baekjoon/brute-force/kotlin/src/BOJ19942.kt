private const val INF = 10000000
private var N = 0
private var result = INF
private var picked = 0
private lateinit var materials: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    val (mp, mf, ms, mv) = readLine().split(" ").map { it.toInt() }

    materials = Array(N) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dfs(0, mp, mf, ms, mv, 0, 0)

    if (picked == 0) {
        print(-1)
    } else {
        println(result)
        for (i in 0 until N) {
            if ((picked and (1 shl i)) != 0) {
                print("${i + 1} ")
            }
        }
    }
}

private fun dfs(
    idx: Int,
    protein: Int,
    fat: Int,
    carbo: Int,
    vitamin: Int,
    price: Int,
    visited: Int
) {
    if (price >= result) {
        return
    }

    if (protein <= 0 && fat <= 0 && carbo <= 0 && vitamin <= 0) {
        result = price
        picked = visited
        return
    }

    if (idx == N) {
        return
    }

    dfs(
        idx + 1,
        protein - materials[idx][0],
        fat - materials[idx][1],
        carbo - materials[idx][2],
        vitamin - materials[idx][3],
        price + materials[idx][4],
        visited or (1 shl idx)
    )

    dfs(
        idx + 1,
        protein,
        fat,
        carbo,
        vitamin,
        price,
        visited
    )

}