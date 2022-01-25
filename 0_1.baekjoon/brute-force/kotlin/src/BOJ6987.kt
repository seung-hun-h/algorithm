import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(4) {
        val st = StringTokenizer(readLine())
        val scores = Array(6){IntArray(3) { 0} }
        var total = 0

        for (i in 0 until 6) {
            for (j in 0 until 3) {
                scores[i][j] = st.nextToken().toInt()
                total += scores[i][j]
            }
        }

        val matches = Array(15) { IntArray(2)}
        var idx = 0
        for (i in 0 until 5) {
            for (j in i + 1 until 6) {
                matches[idx][0] = i
                matches[idx++][1] = j
            }
        }
        val sb = StringBuilder()
        if (total == 30 && dfs(scores, matches, 0)) {
            sb.append(1).append(" ")
        } else {
            sb.append(0).append(" ")
        }

        print(sb)
    }
}

private fun dfs(scores: Array<IntArray>, matches: Array<IntArray>, round: Int): Boolean {
    if (round == 15) {
        return true
    }

    val(team1, team2) = matches[round]

    if (scores[team1][0] > 0 && scores[team2][2] > 0) {
        scores[team1][0]--
        scores[team2][2]--
        if (dfs(scores, matches, round + 1)) return true
        scores[team1][0]++
        scores[team2][2]++
    }

    if (scores[team1][2] > 0 && scores[team2][0] > 0) {
        scores[team1][2]--
        scores[team2][0]--
        if (dfs(scores, matches, round + 1)) return true
        scores[team1][2]++
        scores[team2][0]++
    }

    if (scores[team1][1] > 0 && scores[team2][1] > 0) {
        scores[team1][1]--
        scores[team2][1]--
        if (dfs(scores, matches, round + 1)) return true
        scores[team1][1]++
        scores[team2][1]++
    }
    return false
}