fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { str: String ->  str.toInt()}
    val arr = readLine().split(" ").map { str: String -> str.toInt() }.toIntArray()
    (1 until n)
        .forEach { i -> arr[i - 1] = arr[i] - arr[i - 1] }

    arr.sort()

    val sum = (0 until n - k)
        .sumOf { i -> arr[i] }

    print(sum);
}