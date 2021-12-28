import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a: Int = st.nextToken().toInt()
    val b: Int = st.nextToken().toInt()

    print(getMinimumOperations(a, b))
}

private fun getMinimumOperations(a: Int, b: Int): Int {
    var target: Int = b

    for (i in 1..b) {
        if (target == a)
            return i

        target /= if (target % 10 == 1) {
            10
        } else if (target % 2 == 0) {
            2
        } else {
            return -1
        }
    }
    return -1
}