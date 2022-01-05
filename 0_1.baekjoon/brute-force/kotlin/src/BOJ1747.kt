import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine()!!.toInt()

    var answer = -1

    while (answer == -1) {
        if (isPrime(n) && isPalindrome(n)) {
            answer = n
        }
        n++
    }

    println(answer)
}

private fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }

    val sqrt = sqrt(num.toDouble()).toInt()

    for (i in 2..sqrt) {
        if (num % i == 0)
            return false
    }

    return true
}

private fun isPalindrome(num: Int): Boolean {
    val strNum = num.toString()

    var left = 0
    var right = strNum.length - 1

    while (left < right) {
        if (strNum[left++] != strNum[right--]) {
            return false
        }
    }

    return true
}