fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    combination(result, "", n, n)
    return result
}

fun combination(result: MutableList<String>, current: String, open: Int, close: Int) {
    if (open + close == 0) {
        result.add(current)
        return
    }

    if (open > 0) {
        combination(result, "$current(", open - 1, close)
    }

    if (close > open) {
        combination(result, "$current)", open, close - 1)
    }
}