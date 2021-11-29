fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sequence = readLine()

    val count = mutableMapOf('R' to 0, 'B' to 0)
    var current = sequence[0]
    var next = current

    for (i in 1..n-1) {
        next = sequence[i]

        if (current != next) {
            count[current] = count[current]!! + 1
            current = next
        }
    }

    count[next] = count[next]!! + 1;

    if (sequence.length == 1) {
        println(1)
    } else {
        println(count.minOf { entry -> entry.value } + 1)
    }
}