import kotlin.math.max

val numbers = ArrayList<Int>()
val operators = ArrayList<Char>()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val expression = readLine().trim()

    parse(n, expression)

    println(dfs(numbers[0], 0))
}

private fun dfs(number: Int, idx: Int): Int {
    if (idx == operators.size) {
        return number
    }

    var result = calc(number, numbers[idx + 1], operators[idx])
    var max = dfs(result, idx + 1)

    if (idx + 1 < operators.size) {
        result = calc(numbers[idx + 1], numbers[idx + 2], operators[idx + 1])

        max = max(max, dfs(calc(number, result, operators[idx]), idx + 2))
    }

    return max
}

private fun calc(num1: Int, num2: Int, operator: Char): Int {
    return when (operator) {
        '+' -> num1 + num2
        '*' -> num1 * num2
        else -> num1 - num2
    }
}

private fun parse(
    n: Int,
    expression: String,
) {
    var prev = -1
    for (i in 0 until n) {
        if (!expression[i].isDigit()) {
            numbers.add(expression.substring(prev + 1, i).toInt())
            operators.add(expression[i])

            prev = i
        }
    }

    numbers.add(expression.substring(prev + 1).toInt())
}