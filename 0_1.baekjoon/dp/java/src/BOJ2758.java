import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2758 {
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new long[n + 1][m + 1];

            for (long[] d : dp) {
                Arrays.fill(d, -1);
            }

            for (int i = 0; i < m + 1; i++) {
                dp[1][i] = i;
            }

            sb.append(solve(n, m)).append("\n");
        }

        System.out.println(sb);
    }

    private static long solve(int n, int m) {
        return dfs(n, m);
    }

    private static long dfs(int n, int m) {
        if (m < 0 || n < 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];

        dp[n][m] = 0;

        dp[n][m] += dfs(n - 1, m / 2);
        dp[n][m] += dfs(n, m - 1);

        return dp[n][m];
    }


}
