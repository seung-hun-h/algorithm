import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
  val n: Int = readLine().toInt()
  val st = StringTokenizer(readLine())

  val array = IntArray(n)
  for (i in 0 until n) {
    array[i] = st.nextToken().toInt()
  }

  val acc = IntArray(n)
  acc[0] = array[0]

  for (i in 1 until n) {
    acc[i] = acc[i - 1] + array[i]
  }

  var answer = 0

  for (i in 1 until n-1) {
    var dist1 = acc[i] - acc[0] - array[i]
    var dist2 = acc[n - 1] - acc[i] - array[n - 1]
    var dist3 = acc[n - 1] - acc[0] - array[n - 1]

    answer = max(answer, dist1 + dist2 + array[i] * 2)
    answer = max(answer, dist2 + dist3 + array[n - 1] * 2 - array[i])
    answer = max(answer, dist1 + dist3 + array[0] * 2 - array[i])

  }

  print(answer)
}