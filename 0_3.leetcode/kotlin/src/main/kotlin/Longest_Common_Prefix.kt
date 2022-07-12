fun main() {
    val result =  longestCommonPrefix(arrayOf("flower", "float", "fly"))
    println("result = $result")
}

fun longestCommonPrefix(strs: Array<String?>?): String? {
    val first = strs!![0]!!
    val sb = StringBuilder()
    first.forEachIndexed { idx, prefix ->
        for (i in 1 until  strs.size) {
            if (strs[i]!!.length == idx || strs[i]!![idx] != prefix) {
                return sb.toString()
            }
        }
        sb.append(prefix)
    }

    return sb.toString()
}