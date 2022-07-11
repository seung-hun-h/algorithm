fun main() {
    val result = romanToInt("III")
    println("result = $result")
}

fun romanToInt(s: String): Int {
    val numbers = IntArray(s.length)
    s.forEachIndexed { index, c ->
        val number = when(c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw Exception("Unexpected letter $c")
        }
        numbers[index] = number
    }
    var answer = numbers[numbers.size - 1]
    for (i in 0 until numbers.size - 1) {
        if (numbers[i] < numbers[i + 1]) {
            answer -= numbers[i]
        } else {
            answer += numbers[i]
        }
    }
    return answer
}