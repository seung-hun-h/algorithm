import kotlin.math.abs

fun main() {
    val result = divide(2147483647, 2)
    print(result)
}

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }

    val isNegative = (dividend < 0) xor (divisor < 0)
    var abDividend = abs(dividend)
    var abDivisor = abs(divisor)
    var quotient = 0

    while (abDividend - abDivisor >= 0) {
        var subQuotient = 0
        while (abDividend - (abDivisor shl subQuotient shl 1) >= 0) {
            subQuotient++
        }

        quotient += 1 shl subQuotient
        abDividend -= (abDivisor shl subQuotient)
    }

    return if (isNegative) -quotient else quotient
}