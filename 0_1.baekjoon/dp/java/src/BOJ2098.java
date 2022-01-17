import java.io.*;
import java.util.*;

class BOJ2098 {
    static final int INF = 16 * 1000000;
    static int N, limit;
    static int[][] board, dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        limit = (int)Math.pow(2, N) - 1;
        dp = new int[N][limit + 1];


        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], INF);
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 1));
    }
    private static int dfs(int node, int visited) {
        if (dp[node][visited] != INF)
            return dp[node][visited];

        if (visited == limit) {
            if (board[node][0] == 0) return INF;
            return board[node][0];
        }

        for (int i=0;i<N;i++) {
            if (board[node][i] == 0) continue;
            if ((visited & (1 << i)) != 0) continue;
            dp[node][visited] = Math.min(dp[node][visited], dfs(i, visited | (1 << i)) + board[node][i]);
        }

        return dp[node][visited];
    }
}