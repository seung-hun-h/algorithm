fun letterCombinations(digits: String): List<String> {
    val result = mutableListOf<String>()
    val offset: Char = '2'
    val letters = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    fun combinations(result: MutableList<String>, digits: String, current: String, idx: Int) {
        if (idx == digits.length) {
            if (current.isNotEmpty()) {
                result.add(current)
            }
            return
        }

        val letter = letters[digits[idx] - offset]
        for (ch in letter) {
            combinations(result, digits, current + ch, idx + 1)
        }
    }
    combinations(result, digits, "", 0)
    return result
}