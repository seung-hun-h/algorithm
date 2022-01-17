import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2228 {
    private static final int INF = -32768 * 101;
    private static int[] ps;
    private static int[][] dp;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ps = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ps[i] = ps[i - 1] + Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(N, M));
    }

    private static int dfs(int idx, int section) {
        if (section == 0) {
            return 0;
        }
        if (idx < 0) {
            return INF;
        }
        if (visited[idx][section]) {
            return dp[idx][section];
        }

        visited[idx][section] = true;
        dp[idx][section] = dfs(idx - 1, section);

        for (int i = idx; i > 0; i--) {
            dp[idx][section] = Math.max(dp[idx][section],
                dfs(i - 2, section - 1) + ps[idx] - ps[i - 1]);
        }

        return dp[idx][section];
    }


}


