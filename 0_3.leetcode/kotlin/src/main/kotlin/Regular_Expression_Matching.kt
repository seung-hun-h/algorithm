fun main() {
    print(isMatch("aa", "a*"))
}

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true
    for (c in 2..p.length) {
        dp[0][c] = p[c - 1] == '*' && dp[0][c - 2]
    }

    for (r in 1..s.length) {
        for (c in 1..p.length) {
            if (p[c - 1] == '.' || p[c - 1] == s[r - 1]) {
                dp[r][c] = dp[r - 1][c - 1]
            } else if (p[c - 1] == '*') {
                dp[r][c] = dp[r][c - 2] || ((p[c - 2] == s[r - 1] || p[c - 2] == '.') && dp[r - 1][c])
            }
        }
    }

    return dp[s.length][p.length]
}

