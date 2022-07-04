fun myAtoi(s: String): Int {
    val len = s.length
    var idx = 0
    while (idx < len && s[idx].isWhitespace()) {
        idx++
    }

    if (idx >= len || s[idx] !in '0'..'9' && s[idx] != '-' && s[idx] != '+') return 0

    val isNegative = s[idx] == '-'
    if (!s[idx].isDigit()) idx++
    while (idx < len && s[idx] == '0') idx++
    if (idx == len || s[idx].isLetter()) return 0

    var end = idx
    while (end < len && s[end].isDigit()) end++

    val number = s.substring(idx, end)

    if (number.isEmpty()) return 0

    if (isNegative) {
        val stand = Int.MIN_VALUE.toString().substring(1)
        if (number.length > stand.length || (number.length == stand.length && number >= stand)) {
            return Int.MIN_VALUE
        }
    } else {
        val stand = Int.MAX_VALUE.toString()
        if (number.length > stand.length || (number.length == stand.length && number >= stand)) {
            return Int.MAX_VALUE
        }
    }

    return number.toInt() * (if (isNegative) -1 else 1)
}

fun main() {
    val result = myAtoi("    -42")
    println("result = ${result}")
}