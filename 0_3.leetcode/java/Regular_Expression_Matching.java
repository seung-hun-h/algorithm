public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int c = 2; c <= p.length(); c++) {
            dp[0][c] = p.charAt(c - 1) == '*' && dp[0][c - 2]; // s = ""
        }

        for (int c = 1; c <= p.length(); c++) {
            for (int r = 1; r <= s.length(); r++) {
                if (p.charAt(c - 1) == '.' || p.charAt(c - 1) == s.charAt(r - 1)){
                    dp[r][c] = dp[r - 1][c - 1];
                } else if (p.charAt(c - 1) == '*') {
                    dp[r][c] = dp[r][c - 2] || ((s.charAt(r - 1) == p.charAt(c - 2) || p.charAt(c - 2) == '.' ) && dp[r - 1][c]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
