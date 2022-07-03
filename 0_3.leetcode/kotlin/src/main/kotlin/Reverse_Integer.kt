import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {
    val result = reverse(123)
    println("result = $result")
}

fun reverse(x: Int): Int {
    return x.sign * (x.absoluteValue.toString().reversed().toIntOrNull() ?: 0)
}