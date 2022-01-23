import java.util.*;
import java.io.*;
public class BOJ9084 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            System.out.println(solve(coins, M));
        }
    }

    private static int solve(int[] coins, int M) {
        int[][] dp = new int[coins.length][M + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        dfs(M, coins, 0, dp);

        return dp[0][M];
    }

    private static int dfs(int current, int[] coins, int idx, int[][] dp) {
        if (current == 0) {
            return 1;
        }

        if (current < 0) {
            return 0;
        }

        if (dp[idx][current] != -1) {
            return dp[idx][current];
        }

        dp[idx][current] = 0;

        for (int i=idx;i<coins.length;i++) {
            int coin = coins[i];
            dp[idx][current] += dfs(current - coin, coins, i, dp);

        }

        return dp[idx][current];
    }
}
